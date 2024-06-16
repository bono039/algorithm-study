import sys
sys.setrecursionlimit(10**7)
ans = float('inf')
case_ = 1

dx, dy = [-1,0,1,0], [0,1,0,-1]

def check():
    for i in range(n):
        for j in range(m):
            if board[i][j] == ".":
                return False
    return True

def bt(x,y,cnt):
    global ans
    if check():
        ans = min(ans, cnt)
    if cnt < ans:
        for i in range(4):
            tmp = []
            nx, ny = x, y
            while True:
                nx, ny = nx + dx[i], ny + dy[i]
                if 0 <= nx < n and 0 <= ny < m and board[nx][ny] == ".":
                    tmp.append((nx,ny))
                    board[nx][ny] = "*" # 방문하면 *로 변경
                else:
                    break
            if tmp:
                bt(nx - dx[i], ny - dy[i], cnt + 1) # 다음 탐색 진행
            for a, b in tmp: # 현재까지 지나온 좌표 다시 초기화
                board[a][b] = "."
        board[x][y] = "." # 시작좌표 초기화

while True:
    try:
        n, m = map(int,input().split())
        visited = [[False] * m for _ in range(n)]
        board = [list(input().strip()) for _ in range(n)]
        ans = float('inf')
        for i in range(n):
            for j in range(n):
                if board[i][j] == ".":
                    board[i][j] = "*"
                    bt(i,j,0)
        if ans == float('inf'):
            ans = -1
        print("Case {}: {}".format(case_,ans))
        case_ += 1
    except:
        break