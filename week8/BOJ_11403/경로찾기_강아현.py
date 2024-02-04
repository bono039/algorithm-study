from collections import deque
N = int(input())
in_graph = [list(map(int,input().split())) for _ in range(N)] # 입력 그래프
out_graph = [[0 for _ in range(N)] for _ in range(N)] # 출력 그래프
graph = [[] for _ in range(N+1)]

# bfs를 위한 그래프 생성
for i in range(N):
    for j in range(N):
        if in_graph[i][j] == 1: 
            graph[i+1].append(j+1)
            
def bfs(v, connect):
    q = deque()
    q.append(v)
    while q:
        h = q.popleft()
        connect.append(h)
        for i in graph[h]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
    return connect
for i in range(1,N+1):
    visited = [False]*(N+1)
    # i에서 j로 가는 간선이 있는지를 확인하기 위한 리스트 (연결된 노드를 담는 리스트)
    connect = []
    connect = bfs(i,connect)
    for j in range(len(connect)):
        # 기준 노드
        if j == 0:
            start = connect[j]
        # 연결된 노드
        else:
            out_graph[start-1][connect[j]-1] = 1
for g in out_graph:
    print(*g)