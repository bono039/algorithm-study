def is_right(p):
    left = 0
    for char in p:
        left += 1 if char == "(" else -1
        if left < 0: return False
    return left == 0

def divide(p):
    left = 0
    for i, char in enumerate(p):
        left += 1 if char == "(" else -1
        if left == 0: return p[:i+1], p[i+1:]

def solution(p):
    if not p or is_right(p): return p
    u, v = divide(p)
    if is_right(u): return u + solution(v)
    return '(' + solution(v) + ')' + ''.join(')' if c == '(' else '(' for c in u[1:-1])