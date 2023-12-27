n = int(input())
class_room = [[0 for _ in range(n)] for _ in range(n)]
# 학생의 번호와 학생이 좋아하는 학생의 번호를 담은 리스트
friends = []
# 앉아있는 학생의 번호를 담은 리스트
sit = []

for _ in range(n*n):
    student = list(map(int,input().split()))
    friends.append(student)

# 앉아있는 학생들 중 학생이 좋아하는 학생의 번호가 있는지 확인하기 위한 함수
def friend_seat(friendss):
    who = []
    for f in friendss:
        if f in sit:
            who.append(f)
    return who

for friend in friends:
    if sit == []: # 처음에 앉는 학생은 항상 [2][2]의 위치에 앉게 된다.
        class_room[1][1] = friend[0]
        sit.append(friend[0])
    else:
        sit.append(friend[0])
        who = friend_seat(friend[1:])
        if who != []: # 학생이 좋아하는 학생이 한명이라도 앉아있는 경우
            max_like, max_empty = 0, 0 # 인접해있는 좋아하는 학생이 최대인 수, 주변에 빈자리가 최대인 수
            seat_i, seat_j = 0, 0 # 학생이 앉게 될 자리
            for i in range(n):
                for j in range(n):
                    like = 0
                    empty = 0
                    if class_room[i][j] == 0:
                        # 해당 자리에 좋아하는 학생이 몇명이나 인접해있는지
                        if i-1 >= 0 and class_room[i-1][j] in who: like += 1
                        if j-1 >= 0 and class_room[i][j-1] in who: like += 1
                        if i+1 < n and class_room[i+1][j] in who: like += 1
                        if j+1 < n and class_room[i][j+1] in who: like += 1
                        # 해당 자리 주변에 빈자리가 몇개나 있는지
                        if i-1 >= 0 and class_room[i-1][j] == 0: empty += 1
                        if j-1 >= 0 and class_room[i][j-1] == 0: empty += 1
                        if i+1 < n and class_room[i+1][j] == 0: empty += 1
                        if j+1 < n and class_room[i][j+1] == 0: empty += 1
                        
                        # 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
                        if max_like < like:
                            max_like, max_empty = like, empty
                            seat_i, seat_j = i, j
                        elif max_like == like:
                            # 2. 1을 만족하는 칸 중 인접한 칸 중에 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
                            if max_empty < empty:
                                max_empty = empty
                                seat_i, seat_j = i, j
                            # 3. 2를 만족하는 칸 중 행의 번호와 열의 번호가 가장 작은 칸으로 자리를 정한다.
                            elif max_empty == empty:
                                if class_room[seat_i][seat_j] != 0:
                                    seat_i, seat_j = i, j
                        
            class_room[seat_i][seat_j] = friend[0]

        elif who == []: # 학생이 좋아하는 학생이 한명도 안앉아있는 경우
            max_empty = 0 # 좋아하는 학생이 아직 앉아있지 않기 때문에 빈칸의 수만 고려하면 된다.
            seat_i, seat_j = 0, 0
            for i in range(n):
                for j in range(n):
                    empty = 0
                    if class_room[i][j] == 0:
                        if i-1 >= 0 and class_room[i-1][j] == 0: empty += 1
                        if j-1 >= 0 and class_room[i][j-1] == 0: empty += 1
                        if i+1 < n and class_room[i+1][j] == 0: empty += 1
                        if j+1 < n and class_room[i][j+1] == 0: empty += 1

                        if max_empty < empty:
                            max_empty = empty
                            seat_i, seat_j = i, j
                        elif max_empty == empty:
                            if class_room[seat_i][seat_j] != 0:
                                seat_i, seat_j = i, j

            class_room[seat_i][seat_j] = friend[0]

answer = 0
# 학생의 만족도의 총 합을 구한다.
for i in range(n):
    for j in range(n):
        near_friend = 0
        near = [] # 학생이 좋아하는 학생의 번호
        for friend in friends:
            if friend[0] == class_room[i][j]:
                near = friend[1:]
                break
        if i-1 >= 0 and class_room[i-1][j] in near: near_friend += 1
        if j-1 >= 0 and class_room[i][j-1] in near: near_friend += 1
        if i+1 < n and class_room[i+1][j] in near: near_friend += 1
        if j+1 < n and class_room[i][j+1] in near: near_friend += 1

        if near_friend == 1: answer += 1
        elif near_friend == 2: answer += 10
        elif near_friend == 3: answer += 100
        elif near_friend == 4: answer += 1000
print(answer)