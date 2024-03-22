n, m, k = map(int,input().split())
board = [[[] for _ in range(n)] for _ in range(n)]
fireballs = []

for _ in range(m):
    r,c,m,s,d = map(int,input().split())
    fireballs.append((r-1,c-1,m,s,d))

directions = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]

for _ in range(k):
    while fireballs:
        fr, fc, fm, fs, fd = fireballs.pop()
        nx, ny = (fr + fs*directions[fd][0]) % n, (fc + fs*directions[fd][1]) % n
        board[nx][ny].append([fm,fs,fd])
    for i in range(n):
        for j in range(n):
            if len(board[i][j]) >= 2:
                dm, ds, odd, even, cnt = 0, 0, 0, 0, len(board[i][j])
                while board[i][j]:
                    m, s, d = board[i][j].pop()
                    dm += m
                    ds += s
                    if d % 2: odd += 1
                    else: even += 1
                if odd == cnt or even == cnt:
                    direction = [0,2,4,6]
                else:
                    direction = [1,3,5,7]
                if dm // 5:
                    for direct in direction:
                        fireballs.append([i,j,dm//5,ds//cnt,direct])
            elif len(board[i][j]) == 1:
                fireballs.append([i,j]+board[i][j].pop())
print(sum(fireball[2] for fireball in fireballs))