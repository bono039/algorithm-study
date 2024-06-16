import sys

n = int(input())
s = input()

s_coups = -1 * sys.maxsize

def operation(a,type_,b):
    if type_ == '+':
        return a + b
    if type_ == '-':
        return a - b
    if type_ == '*':
        return a * b

def dfs(index, value):
    global s_coups
    if index == n-1:
        s_coups = max(s_coups,value)
        return
    if index + 2 < n: # 괄호 X
        dfs(index + 2, operation(value, s[index+1], int(s[index+2])))
    if index + 4 < n: # 괄호 O
        dfs(index + 4, operation(value, s[index+1], operation(int(s[index+2]), s[index+3], int(s[index+4]))))
dfs(0,int(s[0]))
print(s_coups)