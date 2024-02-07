from itertools import permutations

N = int(input())
items = [str(i) for i in range(1,10)]
ans = 0
it = [list(map(int,input().split())) for _ in range(N)]
all_num = list(permutations(list(items),3))

def baseball(num, it):
    for i in range(len(it)):
        strike, ball = 0, 0
        guess = list(str(it[i][0]))
        for j in range(3):
            if num[j] in guess:
                if (guess[j] == num[j]) : strike += 1
                else: ball += 1
        if strike != it[i][1] or ball != it[i][2]: return False
    return True

for num in all_num:
    if baseball(num, it): ans += 1

print(ans)