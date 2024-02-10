from itertools import combinations

N = int(input())
ability = [list(map(int, input().split())) for _ in range(N)]
player = [i for i in range(N)] # 전체 플레이어
ans = float('inf')

def calculate_score(team, ability): # 능력치 합 구하는 함수
    score = 0
    for i in range(len(team)):
        for j in range(i+1, len(team)):
            score += ability[team[i]][team[j]] + ability[team[j]][team[i]]
    return score

for i in range(1, N // 2 + 1):
    for team_a in combinations(player, i): # select team a player
        team_b = tuple(x for x in player if x not in team_a) # select team b player
        
        score_a = calculate_score(team_a, ability)
        score_b = calculate_score(team_b, ability)

        diff = abs(score_a - score_b)
        ans = min(ans, diff)

print(ans)