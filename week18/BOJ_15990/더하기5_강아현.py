def dp_table(n):
    MOD = 1000000009

    dp = [[0, 0, 0] for _ in range(n + 1)]
    dp[1] = [1, 0, 0]
    dp[2] = [0, 1, 0]
    dp[3] = [1, 1, 1]

    for i in range(4, n + 1):
        dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % MOD
        dp[i][1] = (dp[i - 2][0] + dp[i - 2][2]) % MOD
        dp[i][2] = (dp[i - 3][0] + dp[i - 3][1]) % MOD

    return dp

t = int(input())
dp = dp_table(100000)
for _ in range(t):
    n = int(input())
    print(sum(dp[n]) % 1000000009)