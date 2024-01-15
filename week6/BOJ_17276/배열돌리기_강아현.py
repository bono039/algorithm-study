T = int(input())
# 반시계 기준으로 함수 작성
def rotate_45_225(graph, left, col, right, row, d):
    if d == 45:
        for i in range(n):
            # left
            graph[n//2][i] = left[i]
            # col
            graph[i][i] = col[i]
            # right
            graph[i][n//2] = right[i]
            # row
            graph[n-i-1][i] = row[i]
    elif d == 225:
        for i in range(n):
            # left
            graph[n//2][i] = left[n-i-1]
            # col
            graph[i][i] = col[n-i-1]
            # right
            graph[i][n//2] = right[n-i-1]
            # row
            graph[n-i-1][i] = row[n-i-1]
    return graph

def rotate_90_270(graph, left, col, right, row, d):
    if d == 90:
        for i in range(n):
            # left
            graph[n-i-1][i] = left[i]
            # col
            graph[n//2][i] = col[i]
            # right
            graph[i][i] = right[i]
            # row
            graph[n-i-1][n//2] = row[i]
    elif d == 270:
        for i in range(n):
            # left
            graph[n-i-1][i] = left[n-i-1]
            # col
            graph[n//2][i] = col[n-i-1]
            # right
            graph[i][i] = right[n-i-1]
            # row
            graph[n-i-1][n//2] = row[n-i-1]
    return graph

def rotate_135_315(graph, left, col, right, row, d):
    if d == 135:
        for i in range(n):
            # left
            graph[n-i-1][n//2] = left[i]
            # col
            graph[n-i-1][i] = col[i]
            # right
            graph[n//2][i] = right[i]
            # row
            graph[n-i-1][n-i-1] = row[i]
    elif d == 315:
        for i in range(n):
            # left
            graph[n-i-1][n//2] = left[n-i-1]
            # col
            graph[n-i-1][i] = col[n-i-1]
            # right
            graph[n//2][i] = right[n-i-1]
            # row
            graph[n-i-1][n-i-1] = row[n-i-1]
    return graph

def rotate_180(graph, left, col, right, row):
    for i in range(n):
        # left
        graph[i][i] = left[n-i-1]
        # col
        graph[i][n//2] = col[n-i-1]
        # right
        graph[i][n-i-1] = right[n-i-1]
        # row
        graph[n//2][i] = row[n-i-1]
    return graph

for t in range(T):
    n, d = map(int,input().split())
    graph = [list(map(int,input().split())) for _ in range(n)]
    left, col, right, row = [], [], [], []
    for i in range(n):
        left.append(graph[i][i])
        col.append(graph[i][n//2])
        right.append(graph[i][n-i-1])
        row.append(graph[n//2][i])
    if d == 45 or d == 225 or d == -135 or d == -315:
        if d == 45 or d == -315 : d = 315
        elif d == 225 or d == -135: d = 135
        rotate_135_315(graph, left, col, right, row, d)
    elif d == 90 or d == 270 or d == -90 or d == -270:
        if d == 90 or d == -270: d = 270
        elif d == 270 or d == -90 : d = 90
        rotate_90_270(graph, left, col, right, row, d)
    elif d == 135 or d == 315 or d == -45 or d == -225:
        if d == 135 or d == -225 : d = 225
        elif d == 315 or d == -45 : d = 45
        rotate_45_225(graph, left, col, right, row, d)
    elif d == 180 or d == -180:
        d = 180
        rotate_180(graph, left, col, right, row)
    for i in range(n):
        print(*graph[i])