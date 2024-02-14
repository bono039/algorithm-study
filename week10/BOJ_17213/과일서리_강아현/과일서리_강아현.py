N = int(input())
M = int(input()) - N

def calculate_combination(n, r):
    result = 1
    for i in range(r):
        result *= n
        n -= 1
        result //= (i + 1)
    return result
ans = calculate_combination(N - 1 + M, min(N - 1, M))

print(ans)