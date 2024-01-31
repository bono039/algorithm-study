import sys
input = lambda: sys.stdin.readline().rstrip()

N = int(input())
sched = [0] + [list(map(int, input().split())) for _ in range(N)]
dp = [0] * (N + 1)

for i in range(1, N+1):
    dp[i] = max(dp[i], dp[i-1])
    day = i + sched[i][0] - 1
    if day <= N:
        dp[day] = max(dp[day], dp[i-1] + sched[i][1])
print(max(dp))