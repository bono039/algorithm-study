king_position, stone_position, n = map(str,input().split())
board = [[chr(i)+str(j) for i in range(65,73)] for j in range(8,0,-1)] # 체스판
king_stone = [[0]*8 for _ in range(8)] # 킹과 돌의 위치 표시
king = [0,0]
stone = [0,0]
for i in range(8):
    for j in range(8):
        if board[i][j] == king_position:
            king_stone[i][j] = "king"
            king = [i,j]
        if board[i][j] == stone_position:
            king_stone[i][j] = "stone"
            stone = [i,j]

def is_valid(x,y):
    return 0 <= x < 8 and 0 <= y < 8

directions = {"R":(0,1),"L":(0,-1),"B":(1,0),"T":(-1,0),"RT":(-1,1),"LT":(-1,-1),"RB":(1,1),"LB":(1,-1)}

def move(x,y,order):
    dx, dy = directions[order][0], directions[order][1]
    nx, ny = x + dx, y + dy
    if is_valid(nx,ny):
        if king_stone[nx][ny] == 0:
            king_stone[x][y] = 0
            x, y = nx, ny
            king_stone[x][y] = "king"
            return x, y
        else:
            stone_x, stone_y = nx + dx, ny + dy
            if is_valid(stone_x,stone_y):
                king_stone[x][y] = 0
                x, y = nx, ny
                king_stone[x][y] = "king"
                king_stone[stone_x][stone_y] = "stone"
                return x, y, stone_x, stone_y
    return x, y

for _ in range(int(n)):
    order = str(input())
    idx = list(move(king[0],king[1],order))
    if len(idx) == 2:
        king = idx
    else:
        king = idx[:2]
        stone = idx[2:]

print(board[king[0]][king[1]])
print(board[stone[0]][stone[1]])