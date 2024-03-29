from collections import deque

n, l, r = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
answer = 0

def bfs(x,y,visited,people, country_cnt):
    q = deque()
    q.append((x,y))
    visited[x][y] = True
    while q:
        x, y = q.popleft()
        now = board[x][y]
        border[x][y] = 1
        people += now
        country_cnt += 1
        for dx, dy in [(-1,0),(0,1),(1,0),(0,-1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < n and (l <= abs(now-board[nx][ny]) <= r) and not visited[nx][ny]:
                q.append((nx,ny))
                visited[nx][ny] = True
    return people, country_cnt

def update(board,border,new):
    for i in range(n):
        for j in range(n):
            if border[i][j] == 1:
                border[i][j] = str(1)
                board[i][j] = new
    return board

while True:
    visited = [[False]*n for _ in range(n)]
    border = [[0]*n for _ in range(n)]
    end = 1
    for i in range(n):
        for j in range(n):
            if not visited[i][j]:
                people, country_cnt = bfs(i,j,visited,0,0)
                if people > 0 and country_cnt > 1:
                    end = 0
                    new = people // country_cnt
                    board = update(board,border,new)
                elif country_cnt <= 1: border[i][j], visited[i][j] = 0, False
    if end == 1: break
    else: answer += 1

print(answer)