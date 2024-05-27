t = int(input())
for _ in range(t):
    k = int(input())
    papers = [0] + list(map(int,input().split()))
    l = [0] * (k+1)
    for i in range(1,k+1):
        l[i] = l[i-1] + papers[i]
    dp = [[0]*(k+1) for _ in range(k+1)]

    for i in range(2,k+1):
        for j in range(1,k+2-i):
            dp[j][j+i-1] = min([dp[j][j+d] + dp[j+d+1][j+i-1] for d in range(i-1)]) +(l[j+i-1] - l[j-1])
    print(dp[1][k])