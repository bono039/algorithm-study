n = int(input())
words = [list(str(input())) for _ in range(n)]
ans = 0
for i in range(1,n):
    t, k = words[i].copy(), words[0].copy()
    for j in range(len(words[i])):
        if words[i][j] in k: 
            k.remove(words[i][j])
            t.remove(words[i][j])
    if len(k) <= 1 and len(t) <= 1: ans += 1
print(ans)