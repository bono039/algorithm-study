s = list(str(input()))
ans = 'z'*50
for i in range(1,len(s)-1):
    for j in range(i+1,len(s)):
        a, b, c = s[:i][::-1], s[i:j][::-1], s[j:][::-1]
        ans = min(ans,''.join(a+b+c))
print(ans)