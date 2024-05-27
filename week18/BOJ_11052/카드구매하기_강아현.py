n = int(input())
cards = [0] + list(map(int,input().split()))
dp = [0] * (n+1)
cards_idx = [[i,v] for i, v in enumerate(cards)]
for i in range(1, n + 1):
    for j in range(1, i + 1):
        dp[i] = max(dp[i], dp[i - j] + cards[j])

print(dp[n])