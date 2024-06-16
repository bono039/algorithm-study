def count_blocks(patterns):
    cnt = 0
    for length, condition in patterns:
        for i in range(c - length + 1):
            if condition(i):
                cnt += 1
    return cnt

def block1():
    return count_blocks([
        (1, lambda i: board[i] >= 0),
        (4, lambda i: board[i] == board[i+1] == board[i+2] == board[i+3])
    ])

def block2():
    return count_blocks([
        (2, lambda i: board[i] == board[i+1])
    ])

def block3():
    return count_blocks([
        (3, lambda i: board[i] == board[i+1] == board[i+2] - 1),
        (2, lambda i: board[i] - 1 == board[i+1])
    ])

def block4():
    return count_blocks([
        (3, lambda i: board[i] - 1 == board[i+1] == board[i+2]),
        (2, lambda i: board[i] == board[i+1] - 1)
    ])

def block5():
    return count_blocks([
        (3, lambda i: board[i] == board[i+1] == board[i+2]),
        (3, lambda i: board[i] - 1 == board[i+1] == board[i+2] - 1),
        (2, lambda i: board[i] - 1 == board[i+1]),
        (2, lambda i: board[i] == board[i+1] - 1)
    ])

def block6():
    return count_blocks([
        (3, lambda i: board[i] == board[i+1] == board[i+2]),
        (2, lambda i: board[i] - 2 == board[i+1]),
        (3, lambda i: board[i] == board[i+1] - 1 == board[i+2] - 1),
        (2, lambda i: board[i] == board[i+1])
    ])

def block7():
    return count_blocks([
        (3, lambda i: board[i] == board[i+1] == board[i+2]),
        (2, lambda i: board[i] == board[i+1]),
        (3, lambda i: board[i] - 1 == board[i+1] - 1 == board[i+2]),
        (2, lambda i: board[i] == board[i+1] - 2)
    ])

c, p = map(int, input().split())
board = list(map(int, input().split()))
blocks = {1: block1(), 2: block2(), 3: block3(), 4: block4(), 5: block5(), 6: block6(), 7: block7()}
print(blocks[p])