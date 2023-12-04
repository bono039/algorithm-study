par = str(input())
answer = 0

pipes = []
for i in range(len(par)):
    if par[i] == '(':
        pipes.append('(')
    else:
        if par[i-1] == '(': # 레이저
            pipes.pop()
            answer += len(pipes)
        else: 
            pipes.pop()
            answer += 1
print(answer)