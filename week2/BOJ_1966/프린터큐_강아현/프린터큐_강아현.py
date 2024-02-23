from collections import deque
import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n, m = map(int,input().split())
    importances = list(map(int,input().split()))
    
    # 문서의 고유 인덱스
    docu_key = deque([i for i in range(n)])
    # 문서의 인덱스별 중요도
    docu_value = deque([i for i in importances])
    # 프린트되는 순서
    print_order = 0
    
    while docu_key:
        # 문서의 인덱스와 중요도를 데크의 제일 왼쪽부터 가져온다.
        t_key = docu_key.popleft()
        t_value = docu_value.popleft()
        # 남은 문서가 1개 이상인 경우 남아있는 중요도보다 앞서 pop한 문서의 중요도가 작은 경우
        if len(docu_value) > 0 and t_value < max(docu_value):
            # 다시 리스트의 맨 뒤에 추가한다.
            docu_key.append(t_key)
            docu_value.append(t_value)
        # 앞서 pop한 문서의 중요도가 데크에서 가장 큰 경우
        else:
            # 프린트 순서 +1
            print_order += 1
            # 몇 번째로 출력되는지 궁금한 문서가 출력되는 경우
            if t_key == m:
                print(print_order)
                break