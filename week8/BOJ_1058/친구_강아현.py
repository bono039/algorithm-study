N = int(input())
in_friends = [0] + [str(input()) for _ in range(N)]
friend_cnt = [0 for _ in range(N+1)]
graph = [[] for _ in range(N+1)]

for i in range(1,N+1):
    for j in range(N):
        if i != (j+1):
            if in_friends[i][j] == "Y": graph[i].append(j+1)
for i in range(1,N+1):
    friend = set()
    for j in graph[i]:
        friend.add(j)
        for k in graph[j]:
            friend.add(k)
    if len(friend) != 0: friend_cnt[i] = len(friend) - 1

print(max(friend_cnt))