n = int(input()) # switch cnt
switch = [0] + list(map(int,input().split()))
m = int(input()) # student cnt

def male(num, switch):
    i = 1
    while num*i <= n:
        switch[num*i] = 1 - switch[num*i]
        i += 1
    return switch

def female(num, switch):
    left = num-1
    right = num+1
    while left > 0 and right <= n: 
        if switch[left] == switch[right]:
            switch[left] = 1 - switch[left]
            switch[right] = 1 - switch[right]
        else: break
        left -= 1
        right += 1
    return switch

for i in range(m):
    sex, num = map(int,input().split())
    if sex == 1:
        male(num, switch)
    else:
        switch[num] = 1 - switch[num]
        female(num, switch)

for i in range(1,n+1,20):
    print(*switch[i:i+20])