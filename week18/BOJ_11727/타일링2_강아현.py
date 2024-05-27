import math

n = int(input())
ans = 0

for i in range(n, -1, -1):
    y = n - i
    if y % 2 == 0:
        cnt = y // 2
        if i != 0:
            tmp = math.comb(i + cnt, cnt)
            ans += tmp * (2 ** cnt)
        else:
            ans += 2 ** cnt
    ans %= 10007

print(ans)