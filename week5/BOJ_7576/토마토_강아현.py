from collections import deque
import sys
input = sys.stdin.readline

M, N = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(N)]
ans = 0

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

q = deque()
# 익은 토마토 위치 추가
for i in range(N):
    for j in range(M):
        if graph[i][j] == 1:
            q.append([i, j])

while q:
    x, y = q.popleft()
    for i in range(4): # 상하좌우 탐색
        nx = x + dx[i]
        ny = y + dy[i]
        if 0 <= nx < N and 0 <= ny < M:
            if graph[nx][ny] == 0:
                graph[nx][ny] = graph[x][y] + 1
                q.append([nx, ny])

for g in graph:
    for tomato in g:
        if tomato == 0: # 안익은 토마토가 하나라도 있는 경우
            print(-1)
            exit()
    ans = max(ans, max(g))
print(ans-1)