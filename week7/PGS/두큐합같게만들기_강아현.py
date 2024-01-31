from collections import deque

def solution(queue1, queue2):
    answer = -1
    q1sum = sum(queue1) # 초기 queue1의 합
    q2sum = sum(queue2) # 초기 queue2의 합
    
    # queue1과 queue2가 같거나 두 리스트의 합이 같으면 연산 과정이 필요없다.
    # 따라서 0을 리턴한다.
    if queue1 == queue2 or q1sum == q2sum:
        return 0

    # queue1과 queue2의 합이 홀수인 경우 두 리스트의 합은 같아질 수 없다.
    # 따라서 -1을 리턴한다.
    if (q1sum + q2sum) % 2 != 0:
        return -1
    
    # 
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    
    cnt = 0
    
    for i in range(len(queue1)*3):
        if q1sum == q2sum:
            return cnt
        elif q1sum > q2sum:
            queue2.append(queue1.popleft())
            q1sum -= queue2[-1]
            q2sum += queue2[-1]
            cnt += 1
        elif q1sum < q2sum:
            queue1.append(queue2.popleft())
            q1sum += queue1[-1]
            q2sum -= queue1[-1]
            cnt += 1

    return answer