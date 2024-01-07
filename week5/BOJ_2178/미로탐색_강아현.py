from collections import deque

N, M = map(int,input().split())
graph = [list(map(int,input())) for _ in range(N)] # 미로

def bfs(graph,N,M):
    q = deque([[0,0,1]])
    # 상하좌우 탐색
    dx = [1,-1,0,0]
    dy = [0,0,1,-1]
    # 미로 시작 위치
    graph[0][0] = 0
    while q:
        nx, ny, answer = q.popleft()
        # 탈출
        if nx == N-1 and ny == M-1:
            return answer
        # 현재 위치에서 상하좌우 탐색
        for i in range(4):
            x, y = nx+dx[i], ny+dy[i]
            if 0 <= x < N and 0 <= y < M and graph[x][y] == 1:
                q.append([x,y,answer+1])
                graph[x][y] = 0
answer = bfs(graph,N,M)
print(answer)