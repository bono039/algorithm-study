from collections import deque

n, w, l = map(int, input().split())
trucks = deque(map(int, input().split()))

cross_bridge = deque([0] * w)
weight = 0 
time = 0 

while trucks:
    weight -= cross_bridge.popleft()
    if weight + trucks[0] <= l:
        weight += trucks[0]
        cross_bridge.append(trucks.popleft())
    else:
        cross_bridge.append(0)
    time += 1

time += w
print(time)