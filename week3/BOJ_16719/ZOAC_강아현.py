word = input()
answer = [word] # 처음에 입력받은 단어는 맨 마지막에 출력한다.
if len(word) > 1:
    t = []
    while True:
        if len(word) == 1:
            break
        else:
            for i in range(len(word)): # word에서 한글자씩 빼면서 사전 순 맨 앞 단어를 추출하도록
                t.append(word[:i]+word[i+1:])
            answer.append(min(t))
            word = min(t) # 원래 word에서 한글자씩 뺀 단어가 word로 재정의된다.
print(*answer[::-1],sep='\n') # answer 원소의 순서를 거꾸로 출력한다.