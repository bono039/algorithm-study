def can_place(board, h, w, sticker, x, y):
    """스티커를 해당 위치에 놓을 수 있는지 확인하는 함수"""
    R, C = sticker
    if x + R > h or y + C > w:
        return False
    for i in range(R):
        for j in range(C):
            if board[x + i][y + j] == 1:
                return False
    return True

def place_sticker(board, sticker, x, y):
    """스티커를 해당 위치에 배치하는 함수"""
    R, C = sticker
    for i in range(R):
        for j in range(C):
            board[x + i][y + j] = 1

def remove_sticker(board, sticker, x, y):
    """스티커를 해당 위치에서 제거하는 함수"""
    R, C = sticker
    for i in range(R):
        for j in range(C):
            board[x + i][y + j] = 0

def get_max_area(h, w, stickers):
    max_area = 0
    n = len(stickers)
    for i in range(n):
        for j in range(i + 1, n):
            for r1, c1 in [(stickers[i][0], stickers[i][1]), (stickers[i][1], stickers[i][0])]:
                for r2, c2 in [(stickers[j][0], stickers[j][1]), (stickers[j][1], stickers[j][0])]:
                    board = [[0] * w for _ in range(h)]
                    placed = False
                    for x1 in range(h):
                        for y1 in range(w):
                            if can_place(board, h, w, (r1, c1), x1, y1):
                                place_sticker(board, (r1, c1), x1, y1)
                                placed = True
                                break
                        if placed:
                            break
                    if not placed:
                        continue

                    placed = False
                    for x2 in range(h):
                        for y2 in range(w):
                            if can_place(board, h, w, (r2, c2), x2, y2):
                                max_area = max(max_area, r1 * c1 + r2 * c2)
                                placed = True
                                break
                        if placed:
                            break

                    remove_sticker(board, (r1, c1), x1, y1)

    return max_area

h, w = map(int, input().split())
n = int(input())
stickers = [list(map(int, input().split())) for _ in range(n)]

print(get_max_area(h, w, stickers))