N, L = map(int,input().split())
water = sorted(list(map(int,input().split())))
start, cnt = water[0] - 0.5, 1
for i in range(1,N):
    if start + L >= water[i] + 0.5: continue
    else:
        start, cnt = water[i] - 0.5, cnt + 1
print(cnt)