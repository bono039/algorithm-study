n = int(input())
distances = list(map(int,input().split()))
oils = list(map(int,input().split()))

min_price = oils[0]
total = 0

for i in range(n-1):
    if min_price > oils[i]:
        min_price = oils[i]
    total += (min_price*distances[i])
print(total)