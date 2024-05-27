n = int(input())
a = list(map(int,input().split()))
dp = [1] * (n+1)
for i in range(n):
    for j in range(i):
        if a[i] > a[j]:
            dp[i] = max(dp[i], dp[j] + 1)
            
for i in range(n):
    for j in range(i,n):
        if a[i] > a[j]:
            dp[j] = max(dp[j], dp[i] + 1)
print(max(dp))