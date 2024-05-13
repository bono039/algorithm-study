from collections import deque

dir = [(0,1),(0,-1),(1,0),(-1,0)] # 1: 동쪽, 2: 서쪽, 3: 남쪽, 4: 북쪽
dir_c = [[2,3],[2,3],[0,1],[0,1]]

def bfs():
    visited = [[[False]*4 for _ in range(n)] for _ in range(m)]
    visited[sx-1][sy-1][sd-1] = 1
    q = deque([(sx-1,sy-1,sd-1,0)])
    while q:
        x, y, d, cnt = q.popleft()
        if (x, y, d) == (ex-1, ey-1, ed-1):
            return cnt
        for i in range(1,4):
            nx, ny = x + dir[d][0] * i, y + dir[d][1] * i
            nd = d
            if not (0 <= nx < m and 0 <= ny < n) or board[nx][ny]:
                break
            if visited[nx][ny][nd]:
                continue
            q.append((nx, ny, nd, cnt+1))
            visited[nx][ny][nd] = True
        for nd in dir_c[d]:
            if visited[x][y][nd]:
                continue
            q.append((x, y, nd, cnt+1))
            visited[x][y][nd] = True

m, n = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(m)]

sx, sy, sd = map(int,input().split()) # 로봇 출발 행, 열, 방향
ex, ey, ed = map(int,input().split()) # 로봇 도착 행, 열, 방향

print(bfs())