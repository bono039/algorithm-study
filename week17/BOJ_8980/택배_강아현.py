n, c = map(int,input().split())
m = int(input())
towns = [list(map(int,input().split())) for _ in range(m)]
towns.sort(key=lambda x:x[1])

boxes = [c] * (n+1)
ans = 0

for s, e, box in towns:
    mc = c
    for i in range(s,e):
        if mc > min(boxes[i],box):
            mc = min(boxes[i], box)
    for i in range(s,e):
        boxes[i] -= mc
    ans += mc
    print(boxes)
print(ans)