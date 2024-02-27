n = str(input())
stack, ans = 0, 0
for i in range(len(n)):
    if n[i] == "(": stack += 1
    else:
        stack -= 1
        ans += stack if n[i-1] == "(" else 1
print(ans)