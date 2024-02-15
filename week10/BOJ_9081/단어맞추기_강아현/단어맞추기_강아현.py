def next_word(word):
    n = len(word)
    # 오른쪽 두 번째 문자부터 시작해서 현재 문자(n-2)보다 큰 문자를 찾기 위한 인덱스
    i = n - 2
    while i >= 0 and word[i] >= word[i + 1]:
        i -= 1
    # i가 -1인 경우는 주어진 단어가 마지막 단어이다.
    if i == -1: return word
    # i 이후의 문자열에서 i 위치의 문자보다 큰 문자를 찾기 위한 인덱스
    j = n - 1
    while word[j] <= word[i]:
        j -= 1
    
    word_list = list(word)
    # i 위치의 문자와 j 위치의 문자를 서로 교환 -> 사전순으로 조금 더 큰 문자열을 얻는다.
    word_list[i], word_list[j] = word_list[j], word_list[i]
    # i 위치 이후의 부분 문자열을 뒤집는다. -> 사전순으로 작은 문자열을 얻는다.
    word_list[i + 1:] = reversed(word_list[i + 1:])
    
    return ''.join(word_list)

T = int(input())
for _ in range(T):
    input_word = input()
    result = next_word(input_word)
    print(result)