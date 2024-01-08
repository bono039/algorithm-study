from collections import deque

n = int(input())
m = int(input())
computers = [[] for _ in range(n+1)]
visited = [False] * (n+1)
for _ in range(m):
    network = list(map(int,input().split()))
    computers[network[0]].append(network[1])
    computers[network[1]].append(network[0])

virus = []
def bfs(v):
    q = deque()
    q.append(v)
    while q:
        x = q.popleft()
        if x not in virus:
            virus.append(x)
        for i in computers[x]:
            if not visited[i]:
                q.append(i)
                visited[i] = True
bfs(1)
print(len(virus)-1)