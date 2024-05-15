n = int(input())
ropes = [int(input()) for _ in range(n)]
ropes.sort(reverse=True)

ans, cnt = 0, 0
for rope in ropes:
    cnt += 1
    if ans < rope * cnt:
        ans = rope * cnt
print(ans)