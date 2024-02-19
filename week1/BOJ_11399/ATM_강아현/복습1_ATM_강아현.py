N, atm_time = int(input()), sorted(map(int, input().split()))
print(sum([sum(atm_time[:i+1]) for i in range(N)]))