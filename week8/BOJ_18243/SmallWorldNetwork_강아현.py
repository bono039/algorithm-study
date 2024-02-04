from collections import deque

def bfs(node, graph, max_distance):
    distance = [0] * (N + 1) # 최대 거리를 6으로 제한하기 위한 거리 리스트
    visited = [False] * (N + 1)
    queue = deque([(node, 0)])
    visited[node] = True
    friend = set()
    while queue:
        current, dist = queue.popleft()
        for neighbor in graph[current]:
            if not visited[neighbor]:
                visited[neighbor] = True
                distance[neighbor] = dist + 1
                if distance[neighbor] <= max_distance:
                    friend.add(neighbor)
                    queue.append((neighbor, distance[neighbor]))
    return friend

N, K = map(int, input().split())
graph = [[] for _ in range(N + 1)]
friend_cnt = [0] * (N + 1)

# 그래프 생성
for _ in range(K):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# 1번 노드부터 N번 노드까지 거리가 최대 6인 노드의 수 구하기
for i in range(1, N + 1):
    friend = bfs(i, graph, 6)
    if friend:
        friend_cnt[i] = len(friend)

friends = list(set(friend_cnt[1:]))

# friends의 길이가 1이 아닌 경우는 이어져 있지 않은 관계가 존재한다는 의미로
# Big World이다.
if len(friends) != 1:
    print("Big World!")
else:
    # friends의 값이 (전체 인원수 - 1)이어야 모든 관계가 이어져 있다.
    if friends[0] == N - 1:
        print("Small World!")
    # 이외의 경우는 안이어진 관계가 존재한다는 것으로 Big World이다.
    else:
        print("Big World!")
