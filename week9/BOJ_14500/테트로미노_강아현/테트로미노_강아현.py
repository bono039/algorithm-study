def check_block(board, i, j, shape):
    block_sum = 0
    for x, y in shape:
        ni, nj = i + x, j + y
        if 0 <= ni < N and 0 <= nj < M:
            block_sum += board[ni][nj]
        else:
            return False
    return block_sum

def max_block_sum(board, i, j, shapes):
    max_sum = 0
    for shape in shapes:
        max_sum = max(max_sum, check_block(board, i, j, shape))
    return max_sum

shapes = [
    [(0, 0), (0, 1), (0, 2), (0, 3)],  # Block 1: 1 X 4 (가로)
    [(0, 0), (1, 0), (2, 0), (3, 0)],  # Block 1: 1 X 4 (세로)

    [(0, 0), (0, 1), (1, 0), (1, 1)],  # Block 2: 2 X 2

    [(0, 0), (0, 1), (0, 2), (-1, 0)], # Block 3: 3 X 2 (가로1)
    [(0, 0), (0, 1), (0, 2), (1, 0)],  # Block 3: 3 X 2 (가로2)
    [(0, 0), (0, 1), (0, 2), (-1, 2)], # Block 3: 3 X 2 (가로3)
    [(0, 0), (0, 1), (0, 2), (1, 2)],  # Block 3: 3 X 2 (가로4)
    [(0, 0), (1, 0), (2, 0), (0, -1)], # Block 3: 3 X 2 (세로1)
    [(0, 0), (1, 0), (2, 0), (0, 1)],  # Block 3: 3 X 2 (세로2)
    [(0, 0), (1, 0), (2, 0), (2, -1)], # Block 3: 3 X 2 (세로3)
    [(0, 0), (1, 0), (2, 0), (2, 1)],  # Block 3: 3 X 2 (세로4)

    [(0, 0), (0, 1), (-1, 1), (-1, 2)],# Block 4: 3 X 2 (가로1)
    [(0, 0), (0, 1), (1, 1), (1, 2)],  # Block 4: 3 X 2 (가로2)
    [(0, 0), (1, 0), (1, -1), (2, -1)],# Block 4: 3 X 2 (세로1)
    [(0, 0), (1, 0), (1, 1), (2, 1)],  # Block 4: 3 X 2 (세로2)

    [(0, 0), (0, 1), (-1, 1), (0, 2)], # Block 5: 2 X 3 (가로1)
    [(0, 0), (0, 1), (1, 1), (0, 2)],  # Block 5: 2 X 3 (가로2)
    [(0, 0), (1, 0), (1, -1), (2, 0)], # Block 5: 2 X 3 (세로1)
    [(0, 0), (1, 0), (1, 1), (2, 0)],  # Block 5: 2 X 3 (세로2)
]

N, M = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]
ans = 0

for i in range(N):
    for j in range(M):
        ans = max(ans, max_block_sum(board, i, j, shapes))

print(ans)