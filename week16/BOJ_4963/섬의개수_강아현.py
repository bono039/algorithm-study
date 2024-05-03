from collections import deque

def search(x,y):
    q = deque()
    q.append((x,y))
    while q:
        x, y = q.popleft()
        visited[x][y] = True
        board[x][y] = 0
        for dx, dy in [(-1,0),(1,0),(0,-1),(0,1),(-1,-1),(-1,1),(1,-1),(1,1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < h and 0 <= ny < w and not visited[nx][ny] and board[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx,ny))
                board[nx][ny] = 0
while True:
        w, h = map(int,input().split())
        if w == 0 and h == 0: break
        if h == 1: board = [[int(input())]]
        else: board = [list(map(int,input().split())) for _ in range(h)]
        visited = [[False]*w for _ in range(h)]
        cnt = 0
        for i in range(h):
            for j in range(w):
                if board[i][j] == 1:
                    search(i,j)
                    cnt += 1
        print(cnt)