n = int(input())
cnt = 1000000000
for i in range((n//5)+1):
    y = (n - (5*i))/3
    if y.is_integer():
        if i + y < cnt: cnt = i + y
if cnt == 1000000000: print(-1)
else: print(round(cnt))