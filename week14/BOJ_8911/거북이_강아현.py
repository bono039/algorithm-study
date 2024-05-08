directions = [(-1,0),(0,1),(1,0),(0,-1)]
t = int(input())

for _ in range(t):
    x, y = 0, 0
    sx, sy, bx, by = 0, 0, 0, 0
    d = 0
    orders = list(input())
    for order in orders:
        if order == "F":
            nx, ny = x + directions[d][0], y + directions[d][1]
        elif order == "B":
            nx, ny = x - directions[d][0], y - directions[d][1]
        elif order == "L":
            d = (d-1) % 4
        elif order == "R":
            d = (d+1) % 4
        if order in ["F","B"]:
            sx, sy, bx, by = min(nx,sx), min(ny,sy), max(nx,bx), max(ny,by)
            x, y = nx, ny
    print((bx-sx)*(by-sy))