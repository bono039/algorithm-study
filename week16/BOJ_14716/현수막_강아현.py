from collections import deque

m, n = map(int,input().split())
banner = [list(map(int,input().split())) for _ in range(m)]

def search_letter(x,y):
    q = deque()
    q.append((x,y))
    while q:
        x, y = q.popleft()
        visited[x][y] = True
        banner[x][y] = 0
        for dx, dy in [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < m and 0 <= ny < n and not visited[nx][ny] and banner[nx][ny] == 1:
                visited[nx][ny] = True
                q.append((nx,ny))
                banner[nx][ny] = 0
cnt = 0
visited = [[False]*n for _ in range(m)]
for i in range(m):
    for j in range(n):
        if banner[i][j] == 1:
            search_letter(i,j)
            cnt += 1

print(cnt)