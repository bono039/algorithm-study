r, c = map(int,input().split())
board = [list(input()) for _ in range(r)]
after_50 = [row[:] for row in board]

for i in range(r):
    for j in range(c):
        cnt = 0
        if board[i][j] == "X":
            for dx, dy in [(-1,0),(0,1),(1,0),(0,-1)]:
                nx, ny = i + dx, j + dy
                if 0 <= nx < r and 0 <= ny < c:
                    if board[nx][ny] == ".": cnt += 1
                else: cnt += 1
            if cnt >= 3:
                after_50[i][j] = "."

sx, sy, bx, by = r-1, c-1, 0, 0
for i in range(r):
    for j in range(c):
        if after_50[i][j] == "X":
            sx, sy, bx, by = min(sx,i), min(sy,j), max(bx,i), max(by,j)

for i in range(sx,bx+1):
    print(''.join(after_50[i][sy:by+1]))