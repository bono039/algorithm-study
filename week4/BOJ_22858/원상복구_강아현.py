n, k = map(int,input().split())
s = list(map(int,input().split())) # 셔플된 카드
d = list(map(int,input().split()))

def shuffle(s, n):
    p = [0 for _ in range(n)] # 셔플되기 전 카드 리스트
    for i in range(n):
        p[d[i]-1] = s[i]
    return p

for _ in range(k):
    s = shuffle(s,n)

p = s
print(*p)