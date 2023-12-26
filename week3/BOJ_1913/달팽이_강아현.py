n = int(input())
target = int(input()) # 위치를 찾고자 하는 자연수
board = [[0 for _ in range(n)] for _ in range(n)]

number = 1
now_x = n // 2 # 1은 항상 board의 가운데에 위치
now_y = n // 2 # 1은 항상 board의 가운데에 위치
now = 'up' # 처음 이동 시 항상 위쪽 방향으로 이동

answer = []
while number != (n*n)+1:
    board[now_x][now_y] = number
    if number == target:
        answer = [now_x+1, now_y+1]

    # now_x와 now_y는 현재 위치로 board를 벗어나는 일이 없다.
    # 따라서 now_x와 now_y에 대한 범위 조건을 추가하지 않아도 된다.
    if now == 'up': # 위쪽으로 이동하는 중
        if board[now_x-1][now_y+1] == 0: # 오른쪽에 위치한 숫자가 0이면 방문을 하지 않은 것
            now_x -= 1
            now = 'right' # 오른쪽으로 방향 전환한다.
        else: # 오른쪽에 위치한 숫자가 0이 아니면 방문을 한 것이므로
            now_x -= 1 # 방향을 전환하지 않고 계속해서 위쪽으로 이동한다.

    # 아래에 right, down, left는 up과 동일한 방식으로 오른쪽에 있는 숫자를 확인하며 진행한다.
    elif now == 'right':
        if board[now_x+1][now_y+1] == 0:
            now_y += 1
            now = 'down'
        else:
            now_y += 1
    elif now == 'down':
        if board[now_x+1][now_y-1] == 0:
            now_x += 1
            now = 'left'
        else:
            now_x += 1
    elif now == 'left':
        if board[now_x-1][now_y-1] == 0:
            now_y -= 1
            now = 'up'
        else:
            now_y -= 1

    number += 1

for i in board:
    print(*i)
print(*answer)