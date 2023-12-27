board = []
for _ in range(5):
    board.append(list(map(int,input().split())))

answer = 0
stop = 0

def bingo(board):
    cnt = 0 # 빙고판에 그어지는 선의 개수
    cross_left, cross_right = 0, 0 # 빙고판의 대각선 검증
    for i in range(5):
        w, h = 0, 0 # 빙고판의 가로/세로 검증
        for j in range(5):
            if board[i][j] == 0: w += 1
            if board[j][i] == 0: h += 1

        if w == 5: cnt += 1 # 가로줄 완성
        if h == 5: cnt += 1 # 세로줄 완성

        if board[i][i] == 0: cross_left += 1 
        if board[i][4-i] == 0: cross_right += 1

    if cross_left == 5: cnt += 1 # 왼쪽 상단 -> 오른쪽 하단 대각선 완성
    if cross_right == 5: cnt += 1 # 오른쪽 상단 -> 왼쪽 하단 대각선 완성

    return cnt

for _ in range(5):
    mc = list(map(int,input().split()))
    for num in mc:
        answer += 1
        idx = [[b[0],b[1].index(num)] for b in enumerate(board) if num in b[1]]
        board[idx[0][0]][idx[0][1]] = 0 # 사회자가 부르는 수 차례로 지워나가기
        cnt = bingo(board) # 빙고인지 확인
        if cnt >= 3: # 3줄 이상 그어지면 빙고!
            stop = 1
            break
    if stop == 1:
        break
print(answer)