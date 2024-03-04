def five(board,n,m):
    n, m = len(board), len(board[0])
    re_board = []
    g1 = [board[i][:m//2] for i in range(n//2)]
    g2 = [board[i][m//2:] for i in range(n//2)]
    g3 = [board[i][:m//2] for i in range(n//2,n)]
    g4 = [board[i][m//2:] for i in range(n//2,n)]
    for i in range(len(g2)):
        re_board.append(g3[i] + g1[i])
    for i in range(len(g1)):
        re_board.append(g4[i] + g2[i])
    return re_board

def six(board,n,m):
    n, m = len(board), len(board[0])
    re_board = []
    g1 = [board[i][:m//2] for i in range(n//2)]
    g2 = [board[i][m//2:] for i in range(n//2)]
    g3 = [board[i][:m//2] for i in range(n//2,n)]
    g4 = [board[i][m//2:] for i in range(n//2,n)]
    for i in range(len(g2)):
        re_board.append(g2[i] + g4[i])
    for i in range(len(g1)):
        re_board.append(g1[i] + g3[i])
    return re_board

n, m, r = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
todo = list(map(int,input().split()))

for i in todo:
    if i == 1: result = [board[len(board) - 1 - i] for i in range(len(board))]
    elif i == 2: result = [row[::-1] for row in board]
    elif i == 3: result = [[board[i][j] for i in range(len(board))][::-1] for j in range(len(board[0]))]
    elif i == 4: result = [[board[i][j] for i in range(len(board))] for j in range(len(board[0]) - 1, -1, -1)]
    elif i == 5: result = five(board,n,m)
    elif i == 6: result = six(board,n,m)
    board = result

for i in board:
    print(*i)