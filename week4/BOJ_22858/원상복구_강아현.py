n, k = map(int,input().split())
s = list(map(int,input().split()))
d = list(map(int,input().split()))

def shuffle(s, n):
    p = [0 for _ in range(n)]
    for i in range(n):
        p[d[i]-1] = s[i]
    return p

for _ in range(k):
    s = shuffle(s,n)

p = s
print(*p)