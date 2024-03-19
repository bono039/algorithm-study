from itertools import combinations

def solution(orders, course):
    answer = []
    for n in course:
        set_menu = {}
        for order in orders:
            for c in combinations(sorted(order), n):
                menu = ''.join(c)
                set_menu[menu] = set_menu.get(menu, 0) + 1
        max_count = max(set_menu.values()) if set_menu else 0
        answer += [k for k, v in set_menu.items() if v == max_count and v >= 2]
    return sorted(answer)