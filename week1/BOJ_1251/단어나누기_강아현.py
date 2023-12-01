from itertools import combinations
word = str(input())
# 단어의 인덱스를 이용
idx_list = [i for i in range(len(word))]
change_word = []
# 단어의 인덱스를 중복없는 조합으로 선택한 후
# 인덱스를 기준으로 단어 자름
for i in combinations(idx_list,3):
    # divide to three words
    a, b, c = word[:idx_list[i[0]]+1], word[idx_list[i[0]]+1:idx_list[i[1]]+1], word[idx_list[i[1]]+1:]
    # reverse
    ra, rb, rc = a[::-1], b[::-1], c[::-1]
    # join
    change_word.append(ra+rb+rc)
# 변형한 단어를 사전 순으로 정렬
change_word.sort()
# 사전에 제일 먼저 나오는 단어 출력
print(change_word[0])
