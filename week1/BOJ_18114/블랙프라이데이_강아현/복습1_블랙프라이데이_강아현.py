N, C = map(int,input().split())
objects_weight = sorted(list(map(int,input().split())))
def binary(start, end, C, weights):
    while start <= end:
        mid = (start + end) // 2
        if weights[mid] == C: return mid
        if weights[mid] < C: start = mid + 1
        else: end = mid - 1
    return -1
def manwon_okay(N, C, objects):
    if C in objects: return True
    else:
        for obje in objects:
            if obje > C: break
            elif ((C-obje) != obje) and binary(0, N-1, C-obje, objects) >= 0: return True
        for i in range(N-2):
            for j in range(j+1, N-1):
                t = objects[i] + objects[j]
                if t > C: return False
                elif C - t != objects[i] and C - t != objects[j] and binary(0, N-1, C-t, objects) >= 0: return True

if manwon_okay(N,C,objects_weight): print(1)
else: print(0)