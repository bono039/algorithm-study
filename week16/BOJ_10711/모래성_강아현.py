from collections import deque

h, w = map(int,input().split())
beach = [list(input()) for _ in range(h)]

directions = [(-1,-1),(-1,0),(-1,1),(0,-1),(0,1),(1,-1),(1,0),(1,1)]
visited = [[0 for _ in range(w)] for _ in range(h)]
q = deque()

for i in range(h):
    for j in range(w):
        if beach[i][j] == '.':
            beach[i][j] = 0
            q.append((i,j))
        else: beach[i][j] = int(beach[i][j])

ans = 0
while q:
    x, y = q.popleft()
    for dx, dy in directions:
        nx, ny = x + dx, y + dy
        if 0 <= nx < h and 0 <= ny < w and beach[nx][ny] != 0:
            beach[nx][ny] -= 1
            if beach[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                ans = max(ans, visited[nx][ny])
                q.append((nx,ny))
print(ans)