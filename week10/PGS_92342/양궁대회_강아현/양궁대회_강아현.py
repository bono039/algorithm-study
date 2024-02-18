from itertools import product

def solution(n, info):
    # 어피치의 공격을 먼저 처리하기 위함
    info.reverse()
    ans = [-1]
    maxd = 0 # 최대로 얻을 수 있는 점수 차이를 저장하는 변수
    for wl in product((True, False), repeat=11): # wl은 라이언 공격 튜플
        t = 0
        # 현재 조합에서 라이언이 공격하는 곳의 점수를 합산한 값을 계산
        s = sum(info[i]+1 for i in range(11) if wl[i])
        # s가 최대 공격 횟수인 n을 넘지 않으면
        if s <= n:
            apeach = sum(i for i in range(11) if not wl[i] and info[i])
            ryan = sum(i for i in range(11) if wl[i])
            d = ryan-apeach
            if d > maxd:
                maxd = d
                ans = [info[i]+1 if wl[i] else 0 for i in range(11)]
                ans[0] += n-s
    # 결과 리스트를 역순으로 되돌린다.
    ans.reverse()
    return ans