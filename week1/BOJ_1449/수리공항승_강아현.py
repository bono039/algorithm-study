import math

n, l = map(int,input().split())
pipes = list(map(int,input().split()))
pipes.sort()

# 테이프 시작 위치
start = pipes[0]-0.5
# 테이프가 끝나는 위치
end = start + l
# 처음 지점에서 테이프를 사용하기 때문에 정답값은 1개 이상이 됨.
ans = 1

for i in range(0, n):
    # 물 새는 곳이 테이프 내에 있는 경우
    if start < pipes[i] < end:
        continue
    # 테이프가 벗어난 위치에 물이 새는 경우
    else:
        ans += 1
        start = pipes[i] - 0.5
        end = start + l

print(ans)