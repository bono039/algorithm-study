from itertools import combinations

n, l, r, x = map(int,input().split())
a = list(map(int,input().split()))
cnt = 0
for i in range(2,n+1):
    for p in combinations(a,i):
        if l <= sum(p) <= r and max(p) - min(p) >= x:
            cnt += 1
print(cnt)