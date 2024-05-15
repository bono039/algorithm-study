import heapq

n = int(input())
classes = [list(map(int, input().split())) for _ in range(n)]
classes.sort(key=lambda x: x[0])

heap = []

# 첫 번째 강의의 종료 시간을 힙에 추가
heapq.heappush(heap, classes[0][1])

for i in range(1, n):
    if classes[i][0] >= heap[0]:
        heapq.heappop(heap)
    # 현재 강의의 종료 시간을 힙에 추가
    heapq.heappush(heap, classes[i][1])

print(len(heap))