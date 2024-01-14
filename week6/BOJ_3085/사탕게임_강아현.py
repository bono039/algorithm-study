import copy
n = int(input())
board = [list(str(input())) for _ in range(n)]
max_candy = 0
def candy_count(board):
    candy = 0
    # 가로
    for i in range(len(board)):
        candy_cnt = 1
        candy_ = board[i][0]
        for j in range(1,len(board)):
            if board[i][j] == candy_:
                candy_cnt += 1
            elif board[i][j] != candy_:
                if candy_cnt > candy: candy = candy_cnt
                candy_ = board[i][j]
                candy_cnt = 1
        if candy_cnt > candy: candy = candy_cnt
    # 세로
    for i in range(len(board)):
        candy_cnt = 1
        candy_ = board[0][i]
        for j in range(1,len(board)):
            if board[j][i] == candy_:
                candy_cnt += 1
            elif board[j][i] != candy_:
                if candy_cnt > candy: candy = candy_cnt
                candy_ = board[j][i]
                candy_cnt = 1
        if candy_cnt > candy: candy = candy_cnt
    return candy
for i in range(n):
    for j in range(n-1):
        b1 = copy.deepcopy(board)
        if b1[i][j] != b1[i][j+1]:
            temp = b1[i][j]
            b1[i][j] = b1[i][j+1]
            b1[i][j+1] = temp
            candy = candy_count(b1)
            if candy > max_candy: max_candy = candy
for i in range(n-1):
    for j in range(n):
        b2 = copy.deepcopy(board)
        if b2[i][j] != b2[i+1][j]:
            temp = b2[i][j]
            b2[i][j] = b2[i+1][j]
            b2[i+1][j] = temp
            candy = candy_count(b2)
            if candy > max_candy: max_candy = candy
print(max_candy)