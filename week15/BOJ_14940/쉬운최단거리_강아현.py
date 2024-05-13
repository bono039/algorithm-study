from collections import deque

n, m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
visited = [[-1]*m for _ in range(n)]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited[x][y] = 0
    while q:
        x, y = q.popleft()
        for dx, dy in [(-1,0),(0,1),(0,-1),(1,0)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m and visited[nx][ny] == -1:
                if board[nx][ny] == 0:
                    visited[nx][ny] = 0
                elif board[nx][ny] == 1:
                    visited[nx][ny] = visited[x][y] + 1
                    q.append((nx,ny))

for i in range(n):
    for j in range(m):
        if board[i][j] == 2 and visited[i][j] == -1:
            bfs(i,j)

for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            print(0, end = " ")
        else:
            print(visited[i][j], end = " ")
    print()