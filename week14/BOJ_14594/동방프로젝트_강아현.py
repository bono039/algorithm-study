n = int(input())
m = int(input())
rooms = [0]*(n+1)
for i in range(m):
    x, y = map(int,input().split())
    rooms[x:y] = [1]*(y-x)
print(rooms.count(0)-1)