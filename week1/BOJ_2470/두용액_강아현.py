import sys
input=sys.stdin.readline

n = int(input())
solutions = list(map(int,input().split()))
solutions.sort()

m = sys.maxsize # 찾고자 하는 부분합 M

answer = []
interval_sum = 0

start = 0
end = n-1

while start < end:
    interval_sum = solutions[start] + solutions[end]
    if abs(interval_sum) < m:
        m = abs(interval_sum)
        answer = [solutions[start], solutions[end]]
    if interval_sum < 0:
        start += 1
    else:
        end -= 1

print(*answer)
