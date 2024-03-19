n, m, h = map(int,input().split())
blocks = [[0] + (list(map(int,input().split()))) for _ in range(n)]

# dp[i][j]: i번째 줄까지 사용해서 높이 j를 만드는 경우의 수
dp = [[0] * (h + 1) for _ in range(n + 1)]
dp[0][0] = 1

for i in range(1, n + 1):
    for j in range(h + 1):
        for block_height in blocks[i - 1]:
            if j >= block_height:
                dp[i][j] += dp[i - 1][j - block_height]
                dp[i][j] %= 10007
print(dp[n][h])