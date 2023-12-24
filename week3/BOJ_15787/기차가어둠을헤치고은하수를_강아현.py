from collections import deque
n, m = map(int,input().split())
trains = [[0 for _ in range(20)] for _ in range(n)] # 모든 기차
answer = [] # 은하수를 건너는 기차
for _ in range(m):
    command = list(map(int,input().split()))
    if command[0] == 1: # 1 i x : i번째 기차의 x번째 승객 탑승
        if trains[command[1]-1][command[2]-1] == 0:
            trains[command[1]-1][command[2]-1] = 1
    elif command[0] == 2: # 2 i x : i번째 기차의 x번째 승객 하차
        if trains[command[1]-1][command[2]-1] == 1:
            trains[command[1]-1][command[2]-1] = 0
    elif command[0] == 3: # 3 i : i번째 기차의 승객 위치 한칸씩 뒤로
        if trains[command[1]-1][-1] == 1: # 마지막 좌석에 승객이 있다면 하차
            trains[command[1]-1][-1] = 0
        temp = deque(trains[command[1]-1])
        temp.rotate(1) # 오른쪽으로 한칸씩 밀기
        trains[command[1]-1] = list(temp)
    elif command[0] == 4: # 4 i : i번째 기차의 승객 위치 한칸씩 앞으로
        if trains[command[1]-1][0] == 1: # 처음 좌석에 승객이 있다면 하차
            trains[command[1]-1][0] = 0
        temp = deque(trains[command[1]-1])
        temp.rotate(-1) # 왼쪽으로 한칸씩 밀기
        trains[command[1]-1] = list(temp)

for train in trains:
    if train not in answer:
        answer.append(train)
print(len(answer))