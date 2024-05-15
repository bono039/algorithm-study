def flip_coin(x, y):
    for i in range(x+1):
        for j in range(y+1):
            coins[i][j] = '1' if coins[i][j] == '0' else '0'

n, m = map(int, input().split())
coins = [list(input()) for _ in range(n)]
ans = 0

for i in range(n-1, -1, -1):
    for j in range(m-1, -1, -1):
        if coins[i][j] == '1':
            ans += 1
            flip_coin(i, j)
print(ans)