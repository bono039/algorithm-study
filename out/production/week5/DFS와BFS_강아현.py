from collections import deque

n, m, v = map(int,input().split())
graph = [[] for _ in range(n+1)]
visited_dfs = [False]*(n+1)
visited_bfs = [False]*(n+1)

for _ in range(m):
    con = list(map(int,input().split()))
    graph[con[0]].append(con[1])
    graph[con[1]].append(con[0])

for i in range(n+1):
    graph[i].sort()

def dfs(v):
    visited_dfs[v] = True
    print(v, end = ' ')
    for i in graph[v]:
        if not visited_dfs[i]:
            dfs(i)

bfs_ = []
def bfs(v):
    q = deque()
    q.append(v)
    while q:
        x = q.popleft()
        if x not in bfs_: bfs_.append(x)
        for i in graph[x]:
            if not visited_bfs[i]:
                q.append(i)
                visited_bfs[i] = True

dfs(v)
print('')
bfs(v)
print(*bfs_)