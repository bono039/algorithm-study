from collections import deque
n, m, r = map(int, input().split()) # 배열의 크기 : N X M, 회전의 수 : R
board = []

for _ in range(n):
    board.append(list(map(int,input().split())))

def rotate(board, n, m):
    for i in range(min(n,m)//2): # 회전할 수 있는 배열의 가장 바깥 배열부터 가장 안쪽 배열까지

        top = deque(board[i][i:m-i]) # 위쪽 배열을 왼쪽으로 회전
        top.rotate(-1)

        right = deque([]) # 오른쪽 배열을 위쪽으로 회전
        for j in range(i,n-i):
            right.append(board[j][m-i-1])
        right.rotate(-1)

        down = deque(board[n-i-1][i:m-i]) # 아래쪽 배열을 오른쪽으로 회전
        down.rotate(1)

        left = deque([]) # 왼쪽 배열을 아래쪽으로 회전
        for j in range(i,n-i):
            left.append(board[j][i])
        left.rotate(1)

        # 왼쪽 배열 빼고는 위에서 회전한 배열을 그대로 갖다 붙인다.
        board[i][i:m-i] = list(top)
        right = list(right)
        for j in range(len(right)-1):
            board[j+i][m-i-1] = right[j]
        board[n-i-1][i:m-i] = list(down)
        # 위쪽 배열의 첫번째 원소 위치를 제외한 나머지 부분만 붙인다.
        left = list(left)
        for j in range(1,len(left)):
            board[j+i][i] = left[j]


    return board
for _ in range(r):
    board = rotate(board,n,m)
for b in board:
    print(*b)