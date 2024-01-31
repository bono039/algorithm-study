N = int(input())
A = list(map(int,input().split()))
dp=[1]*N
for i in range(1,N):
    for j in range(i):
        if A[i]>A[j]: 
            dp[i]=max(dp[i],dp[j]+1) ## 1씩 증가시켜서 갱신한다.
print(max(dp))