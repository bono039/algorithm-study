from collections import deque

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(x,y,cnt):
    q=deque()
    q.append((x,y,cnt))
    while q:
        x,y,cnt = q.popleft()
        if x == n-1 and y == m-1:
            return visit[x][y][cnt]
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]
            if 0 <= nx < n and 0 <= ny < m:
                if board[nx][ny] == 1 and cnt == 0:
                    visit[nx][ny][1] = visit[x][y][0]+1
                    q.append((nx,ny,1))
                elif board[nx][ny] == 0 and visit[nx][ny][cnt] == 0:
                    visit[nx][ny][cnt]= visit[x][y][cnt]+1
                    q.append((nx,ny,cnt))
    return -1

n,m = map(int, input().split())
board=[list(map(int, input().rstrip())) for _ in range(n)]

visit=[[[0]*2 for _ in range(m)] for _ in range(n)]
visit[0][0][0]=1

print(bfs(0,0,0))