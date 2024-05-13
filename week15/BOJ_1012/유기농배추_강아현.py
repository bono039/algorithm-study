from collections import deque

t = int(input())
for _ in range(t):
    m, n, k =  map(int,input().split())
    board = [[0]*m for _ in range(n)]
    for _ in range(k):
        a, b = map(int,input().split())
        board[b][a] = 1

    def bfs(x,y,visited):
        q = deque()
        q.append((x,y))
        while q:
            x, y = q.popleft()
            visited[x][y] = True
            board[x][y] = 0
            for dx, dy in [(-1,0),(0,1),(1,0),(0,-1)]:
                nx, ny = x + dx, y + dy
                if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx,ny))
                    visited[nx][ny] = True
                    board[nx][ny] = 0
        return visited

    visited = [[False]*m for _ in range(n)]
    answer = 0

    while True:
        end = 0
        for i in range(n):
            for j in range(m):
                if board[i][j] == 1:
                    answer += 1
                    end = 1
                    visited = bfs(i,j,visited)
                    break
        if end == 0: break

    print(answer)