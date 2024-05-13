from collections import deque

w, h =map(int,input().split())
board = [[0 for _ in range(w+2)] for _ in range(h+2)]

for i in range(1,h+1):
    board[i][1:w+1] = map(int,input().split())

dx = [-1,-1,0,1,1,0]
dy = [[-1,0,1,0,-1,-1], [0,1,1,1,0,-1]]

def bfs(x,y):
    q = deque()
    q.append((x,y))
    visited = [[False]*(w+2) for _ in range(h+2)]
    visited[x][y] = True
    cnt = 0
    while q:
        x, y = q.popleft()
        for i in range(6):
            nx, ny = x + dx[i], y + dy[x%2][i]
            if 0 <= nx < h+2 and 0 <= ny < w+2:
                if board[nx][ny] == 0 and not visited[nx][ny]:
                    q.append((nx,ny))
                    visited[nx][ny] = True
                elif board[nx][ny] == 1:
                    cnt += 1
    return cnt
print(bfs(0,0))