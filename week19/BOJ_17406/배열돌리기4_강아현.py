from collections import deque
from itertools import permutations
import copy

n, m, k = map(int,input().split())
ori_board = [list(map(int,input().split())) for _ in range(n)]
a = [list(map(int,input().split())) for _ in range(k)]
ans = float("inf")

for permu in permutations(a,k):
    board = copy.deepcopy(ori_board)
    for p in permu:
        r, c, s = p[0]-1, p[1]-1, p[2]
        for i in range((2*s + 1)//2):
            q = board[r-s+i][c-s+i:c+s-i+1]
            for j in range(r-s+i+1, r+s-i):
                q.append(board[j][c+s-i])
            q += list(board[r+s-i][c-s+i:c+s-i+1])[::-1]
            for j in range(r+s-i, r-s+i, -1):
                q.append(board[j-1][c-s+i])
            q = deque(q)
            q.rotate(1)
            if q:
                for j in range(c-s+i,c+s-i+1):
                    board[r-s+i][j] = q.popleft()
            if q:
                for j in range(r-s+i+1, r+s-i):
                    board[j][c+s-i] = q.popleft()
            if q:
                for j in range(c+s-i,c-s+i-1,-1):
                    board[r+s-i][j] = q.popleft()
            if q:
                for j in range(r+s-i, r-s+i, -1):
                    board[j-1][c-s+i] = q.popleft()

    for b in board:
        if sum(b) < ans:
            ans = sum(b)
print(ans)