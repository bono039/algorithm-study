word = input()
l = []
result = 0
n = 1

for i in range(len(word)):
    if word[i] == '(':
        l.append('(')
        n *= 2
    elif word[i] == '[':
        l.append('[')
        n *= 3
    elif word[i] == ')':
        if not l or l[-1] != '(':
            result = 0
            break
        if word[i-1] == '(':
            result += n
        l.pop()
        n //= 2
    elif word[i] == ']':
        if not l or l[-1] != '[':
            result = 0
            break
        if word[i-1] == '[':
            result += n
        l.pop()
        n //= 3
if l:
    result = 0
print(result)