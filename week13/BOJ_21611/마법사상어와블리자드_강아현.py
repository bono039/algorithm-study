from collections import deque

n, m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]

shark = ((n+1)//2-1,(n+1)//2-1)


directions = [(-1,0),(1,0),(0,-1),(0,1)]
move_directions = [(0,-1),(1,0),(0,1),(-1,0)]

def destroy(d,s): # 구슬 파괴
    dx, dy = directions[d-1][0], directions[d-1][1]
    nx, ny = shark[0], shark[1]
    for i in range(s):
        nx, ny = nx + dx, ny + dy
        board[nx][ny] = 0

def check_four(l,marbles): # 구슬 폭발
    now, cnt = 0, 0
    for i in range(len(l)):
        if now != l[i]:
            if cnt >= 4:
                marbles[l[i-1]-1] += cnt
                l[i-cnt:i] = [0]*cnt
            now, cnt = l[i], 1
        elif now == l[i]:
            cnt += 1
            if cnt >= 4:
                if i == len(l)-1:
                    marbles[l[i]-1] += cnt
                    l[i-cnt+1:i+1] = [0]*cnt
    remove_l = [l[i] for i in range(len(l)) if l[i] > 0]
    return remove_l

def add_marble(l):
    a, b = 0, 0 # cnt, now
    add_l = []
    for i in range(len(l)):
        if b != l[i]:
            if a >= 1:
                add_l += [a,b]
            a, b = 1, l[i]
            if i == len(l)-1:
                add_l += [a, b]
        else:
            a += 1
            if i == len(l)-1:
                add_l += [a,b]
    return add_l

def move(board,marbles):
    x, y = shark[0], shark[1]
    i = 0 # move_directions index
    j = 0 # 이동하는 거리
    l = []

    while True:
        if x == 0 and y == 0: break
        if i % 4 == 0 or i % 4 == 2: j += 1
        for _ in range(j):
            x, y = x + move_directions[i%4][0], y + move_directions[i%4][1]
            if x == 0 and y == 0: break
            if board[x][y] > 0:
                l.append(board[x][y])
                board[x][y] = 0
        i += 1

    # 구슬이 4개 이상인 경우가 있는지 확인
    while True:
        new_l = check_four(l,marbles)
        if len(l) == len(new_l):
            break
        if len(l) != len(new_l):
            l = new_l

    # 하나의 그룹을 두 개의 구슬 A, B로 바꿔서 넣는다.
    l = deque(add_marble(l))

    i, j = 0, 0
    x, y = shark[0], shark[1]
    while True:
        if x == 0 and y == 0: break
        if len(l) == 0: break
        if i % 4 == 0 or i % 4 == 2: j += 1
        for _ in range(j):
            x, y = x + move_directions[i%4][0], y + move_directions[i%4][1]
            if len(l) == 0: break
            if x == 0 and y == 0: break
            board[x][y] = l.popleft()
        i += 1



marbles = [0,0,0] # 폭발한 1, 2, 3번의 구슬의 개수

for _ in range(m):
    d, s = map(int,input().split())
    destroy(d,s)
    move(board,marbles)

print(sum([(i+1)*marbles[i] for i in range(3)]))