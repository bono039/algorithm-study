n = int(input())
board = [] # 지뢰게임 판
for _ in range(n):
    board.append(list(input()))

def bomb(board,i,j): # 모든 방면에 지뢰가 있는지 확인하기 위한 함수
    bomb_cnt = 0
    if i-1 >= 0: # 현재 위치 기준 위쪽
        if j-1 >= 0:
            if board[i-1][j-1] == '*':
                bomb_cnt += 1
        if board[i-1][j] == '*':
            bomb_cnt += 1
        if j+1 < len(board[0]):
            if board[i-1][j+1] == '*':
                bomb_cnt += 1
    if j-1 >= 0: # 현재 위치 기준 왼쪽
        if board[i][j-1] == '*':
            bomb_cnt += 1
    if board[i][j] == '*': # 현재 위치에 지뢰가 있다면 '*' 표시로 return 
        return '*'
    if j+1 < len(board[0]): # 현재 위치 기준 오른쪽
        if board[i][j+1] == '*':
            bomb_cnt += 1
    if i+1 < len(board[0]): # 현재 위치 기준 아래쪽
        if j-1 >= 0:
            if board[i+1][j-1] == '*':
                bomb_cnt += 1
        if board[i+1][j] == '*':
            bomb_cnt += 1
        if j+1 < len(board[0]):
            if board[i+1][j+1] == '*':
                bomb_cnt += 1
    return bomb_cnt

open_board = [] # 열린 보드
for _ in range(n):
    open_board.append(list(input()))

bomb_open = 0 # 지뢰가 있는 곳 고른 횟수
for i in range(n):
    for j in range(n):
        if open_board[i][j] == 'x':
            open_board[i][j] = bomb(board,i,j)
            if open_board[i][j] == '*': # 현재 위치에 지뢰가 있다면 bomb_open + 1
                bomb_open += 1


if bomb_open > 0: # 지뢰가 있는 칸이 열린 경우
    for t in range(n): # 지뢰의 모든 위치 표시
        for k in range(n):
            if board[t][k] == '*':
                open_board[t][k] = '*'
for o in open_board:
    print(*o,sep='')