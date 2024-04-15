r, c, n = map(int,input().split())
board = [list(input()) for _ in range(r)]

def first_bomb(board):
    for i in range(r):
        for j in range(c):
            if board[i][j] == 'O':
                board[i][j] = 2

def bomb_second(board):
    for i in range(r):
        for j in range(c):
            if board[i][j] != '.' and board[i][j] > 0:
                board[i][j] -= 1

def bomb_all(board):
    for i in range(r):
        for j in range(c):
            if board[i][j] == '.':
                board[i][j] = 2

def bomb(board):
    for i in range(r):
        for j in range(c):
            if board[i][j] == 0:
                board[i][j] = '.'
                for dx, dy in [(-1,0),(0,1),(0,-1),(1,0)]:
                    nx, ny = i + dx, j + dy
                    if 0 <= nx < r and 0 <= ny < c and board[nx][ny] != 0 and board[nx][ny] != '.':
                        board[nx][ny] = '.'
t = 1
while True:
    first_bomb(board)
    if t >= n: break
    bomb_second(board)
    bomb_all(board)
    t += 1
    if t >= n: break
    bomb_second(board)
    bomb(board)
    t += 1

for i in range(r):
    for j in range(c):
        if board[i][j] != '.' and board[i][j] >= 0: board[i][j] = 'O'

for b in board:
    print(''.join(b))