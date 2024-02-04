N, D = map(int,input().split())
short_drive = [list(map(int,input().split())) for _ in range(N)]
graph = [i for i in range(D+1)]

for i in range(D+1):
    if i > 0: graph[i] = min(graph[i], graph[i-1]+1)
    for a, b, c in short_drive:
        if i == a and D >= b and graph[b] > graph[i]+c:
            graph[b] = graph[i]+c
print(graph[D])