from collections import deque

N, M, K, X = map(int,input().split())
graph = [[]for _ in range(N+1)]

for _ in range(M):
    A, B = map(int,input().split())
    graph[A].append(B)

dist = [0 for _ in range(N+1)]
visited = [False] * (N+1)
q = deque([X])
visited[X] = True
while q:
    now = q.popleft()
    for i in graph[now]:
        if not visited[i]:
            q.append(i)
            visited[i] = True
            dist[i] = dist[now] + 1
print(dist)
check = 0
for i in range(1, N+1):
    if dist[i] == K:
        print(i)
        check += 1
if check == 0: print(-1)
    