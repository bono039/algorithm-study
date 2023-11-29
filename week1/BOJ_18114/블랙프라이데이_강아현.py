from itertools import combinations
import sys

input=sys.stdin.readline

def binary(start, end, c, weights):
    while start <= end:
        mid = (start + end) // 2
        if weights[mid] == c:
            return mid
        if weights[mid] < c:
            start = mid + 1
        else:
            end = mid - 1
    return -1

def solution(n, c, obje):
    select_object = 0

    # 1개의 물건으로 조건을 만족하는 경우
    if binary(0,n-1,c,obje) >= 0:
        return True

    # 2개의 물건으로 조건을 만족하는 경우
    for i in obje:
            if i > c:
                break
            elif ((c-i) != i) and binary(0, n-1, c-i, obje) >= 0:
                return True
                
    # 3개의 물건으로 조건을 만족하는 경우
    for j in range(n-2):
            for k in range(j+1,n-1):
                t = obje[j] + obje[k]
                if t > c:
                    return False
                elif c-t != obje[j] and c-t != obje[k] and binary(0, n-1, c-t, obje) >= 0:
                    return True
                
                
n, c = map(int, input().split())
obje = list(map(int, input().split()))
obje.sort()

if solution(n,c,obje):
    print(1)
else:
    print(0)
