from collections import deque
N = int(input())
balloons = deque(enumerate(list(map(int,input().split())), start = 1))

while balloons:
    idx, value = balloons.popleft()
    balloons.rotate(-value+1) if value > 0 else balloons.rotate(-value)
    print(idx, end=" ")