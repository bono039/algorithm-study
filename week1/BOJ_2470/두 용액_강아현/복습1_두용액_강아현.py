import sys

N = int(input())
solutions = sorted(list(map(int,input().split())))
start, end = 0, N-1
min_diff, ans = sys.maxsize ,[0, 0]

while start < end:
    mid_sum = solutions[start] + solutions[end]
    if min_diff > abs(mid_sum):
        min_diff = abs(mid_sum)
        ans = [solutions[start], solutions[end]]
    if mid_sum < 0: start += 1
    else: end -= 1
    
print(*ans)