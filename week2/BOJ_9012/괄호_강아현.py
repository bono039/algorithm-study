import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    left = [] # '('를 보관할 리스트
    right = [] # 괄호가 완성되지 않은 경우 ')'를 보관할 리스트
    par = str(input()) # 괄호 문자열

    for i in range(len(par)):
        if par[i] == '(': # '('인 경우에는 left 리스트에 추가
            left.append(par[i])
        elif par[i] == ')': # ')'인 경우에는 left 리스트 pop
            if left != []: # left 리스트에 (가 하나라도 있는 경우
                left.pop()
            else: # left에 (가 없는 경우에는 올바른 괄호가 아니므로 right 리스트에 추가한 후 break
                right.append(par[i])
                break

    if right != [] or left != []:
        print("NO")
    else:
        print("YES")