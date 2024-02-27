from collections import deque
n = int(input())
balloons = deque(enumerate(list(map(int,input().split()))))
idx = []

while balloons:
    b = balloons.popleft()
    move = b[1] # 풍선 안 종이의 값
    idx.append(b[0]+1) # 풍선의 인덱스
    
    # 풍선 안 종이의 값이 양수인 경우 시계방향으로 (값-1)만큼 회전
    if move > 0:
        balloons.rotate(-(move-1))
    # 풍선 안 종이의 값이 음수인 경우 반시계방향으로 (값)만큼 회전
    else:
        balloons.rotate(-move)
        
print(*idx)