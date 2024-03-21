n, k = map(int,input().split())
people = list(range(1, n+1))
output = []

while people:
    idx = (k-1) if len(people) >= k else (k-1) % (len(people))
    output += [people[idx]]
    people = people[idx+1:] + people[:idx]

print(str(output).replace('[','<').replace(']','>'))