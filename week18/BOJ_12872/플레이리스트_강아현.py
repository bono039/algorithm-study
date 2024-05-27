n, m, p = map(int,input().split())

dp = [[0]*(p+1) for _ in range(n+1)]
dp[0][0] = 1

for i in range(1, p+1):
    for j in range(1, n+1):
        dp[j][i] += dp[j-1][i-1] * (n - (j-1))
        if j > m:
            dp[j][i] += dp[j][i-1] * (j-m)
        dp[j][i] %= 1000000007
        print(dp)
print(dp[n][p])