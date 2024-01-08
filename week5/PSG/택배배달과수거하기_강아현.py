from itertools import zip_longest as zip

def tolist(l):
    n=[]
    for i,d in enumerate(l):
        for _ in range(d):
            n.append(i+1)
    return n

def solution(cap, n, deliveries, pickups):
    d=tolist(deliveries) # 집별로 배달할 택배 수만큼 리스트에 집 번호를 모두 나타낸다.
    p=tolist(pickups) # 집별로 수거할 택배 수만큼 리스트에 집 번호를 모두 나타낸다.
    d.reverse()
    p.reverse()
    d=d[::cap] # cap 수만큼씩 자른다.
    p=p[::cap]
    return 2*sum([max(x,y) for x,y in zip(d,p,fillvalue=0)])
