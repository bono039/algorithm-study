from itertools import combinations

N = int(input())
ingredient = [list(map(int,input().split())) for _ in range(N)]
# 재료 조합의 모든 경우의 수 (1개 사용 ~ 모든 재료 사용)
mix = [list(combinations(ingredient,i)) for i in range(1,N+1)]
ans = 1e9
for m in mix:
    for i in m:
        a, b = 1, 0
        for j in range(len(i)):
            a *= i[j][0]
            b += i[j][1]
        if abs(a-b) < ans: ans = abs(a-b)
print(ans)