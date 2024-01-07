from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
trust = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int,input().split())
    trust[b].append(a)

computer = []
for i in range(1,N+1):
    visited = [False]*(N+1)
    q = deque([i])
    visited[i] = True
    cnt = 1
    while q:
        x = q.popleft()
        for j in trust[x]:
            if not visited[j]:
                q.append(j)
                visited[j] = True
                cnt += 1
    computer.append(cnt)

max_computer = max(computer)

for i in range(N):
    if computer[i] == max_computer:
        print(i+1, end = ' ')