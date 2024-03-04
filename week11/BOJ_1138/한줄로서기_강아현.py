n = int(input())
people = list(map(int,input().split()))

line = [0 for _ in range(n)]
l = [i for i in range(n)]
for i in range(n):
    temp = i+1
    c = l[people[i]]
    line[c] = temp
    l.remove(c)
print(*line)