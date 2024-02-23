from collections import deque

for _ in range(int(input())):
    n, m = map(int, input().split())
    importances = list(map(int, input().split()))
    idx = deque(enumerate(importances))
    order = 1
    while True:
        docu = idx.popleft()
        if docu[1] == max(importances):
            if docu[0] == m:
                print(order)
                break
            else:
                importances.remove(docu[1]) 
                order += 1

        else: idx.append(docu)