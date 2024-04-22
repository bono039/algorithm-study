n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]
dp = [[0]*n for _ in range(n)]
dp[0][0] = 1
for i in range(n):
    for j in range(n):
        k = board[i][j]
        if k == 0 or dp[i][j] == 0:
            continue
        if i + k < n: # 행 
            dp[i+k][j] += dp[i][j]
        if j + k < n: # 열
            dp[i][j+k] += dp[i][j]
print(dp[-1][-1])