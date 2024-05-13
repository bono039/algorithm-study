from collections import deque

n = int(input())
board = [list(str(input())) for _ in range(n)]
visited = [[False]*n for _ in range(n)]
apart = []

def bfs(x,y,cnt):
    q = deque()
    q.append((x,y))
    while q:
        x, y = q.popleft()
        visited[x][y] = True
        board[x][y] = '0'
        for dx, dy in [(-1,0),(0,1),(0,-1),(1,0)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n and board[nx][ny] == '1' and not visited[nx][ny]:
                cnt += 1
                visited[nx][ny] = True
                board[nx][ny] = '0'
                q.append((nx,ny))
    return cnt

for i in range(n):
    for j in range(n):
        if board[i][j] == '1' and not visited[i][j]:
            apart.append(bfs(i,j,1))

print(len(apart))
apart.sort()
for a in apart:
    print(a)