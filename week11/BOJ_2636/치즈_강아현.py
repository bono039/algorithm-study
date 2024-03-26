from collections import deque

def bfs(n, m):
    q.append((0,0))
    visited = [[0] * m for _ in range(n)]
    visited[0][0] = 1
    cnt = 0
    while q:
        x, y = q.popleft()
        for dx, dy in [[1,0],[0,1],[-1,0],[0,-1]]:
            nx, ny = x + dx, y + dy
            if 0 <= nx < n and 0 <= ny < m:
                if cheese[nx][ny] == 0 and visited[nx][ny] == 0:
                    visited[nx][ny] = 1
                    q.append((nx,ny))
                elif cheese[nx][ny] == 1:
                    cheese[nx][ny] = 0
                    cnt += 1
                    visited[nx][ny] = 1
    return cnt

n, m = map(int,input().split())
cheese = [list(map(int,input().split())) for _ in range(n)]
q = deque()

cheeses = []
time = 0
while True:
    cheeses.append(bfs(n,m))
    time += 1
    if sum(map(sum, cheese)) == 0: break
print(time)
print(cheeses[-1])
