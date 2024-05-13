from collections import deque
import copy

n, m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
answer = 0

dx, dy = [0,0,1,-1], [1,-1,0,0]

def bfs():
    q = deque()
    graph = copy.deepcopy(board)
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                q.append((i,j))
    while q:
        x, y = q.popleft()
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                graph[nx][ny] = 2
                q.append((nx,ny))
    cnt = 0
    for i in range(n):
        cnt += graph[i].count(0)

    global answer
    answer = max(answer,cnt)

def wall(cnt):
    if cnt == 3:
        bfs()
        return
    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                board[i][j] = 1
                wall(cnt+1)
                board[i][j] = 0
wall(0)
print(answer)