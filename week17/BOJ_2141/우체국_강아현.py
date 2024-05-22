n = int(input())
towns = [list(map(int, input().split())) for _ in range(n)]

# 위치를 기준으로 정렬
towns.sort()

# 총 인구의 절반을 구합니다
total_population = sum(town[1] for town in towns)
half_population = total_population / 2

# 누적 인구를 구하면서 절반 인구를 넘는 지점을 찾습니다
current_population = 0
for town in towns:
    current_population += town[1]
    if current_population >= half_population:
        print(town[0])
        break