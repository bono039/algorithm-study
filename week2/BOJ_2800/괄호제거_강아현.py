from itertools import combinations

n = list(input())
answer = set()
# 괄호의 인덱스를 뽑기 위한 스택
stack = []
# 괄호의 인덱스
idx = []

for i in range(len(n)):
    if n[i] == "(":
        stack.append(i)
    elif n[i] == ")":
        idx.append((stack.pop(), i))

# 1부터 괄호의 개수만큼까지의 조합
# 괄호를 제거해서 만들 수 있는 모든 경우의 수를 구한다.
for i in range(len(idx)):
    for c in combinations(idx,i+1):
        target = n[:]
        # 괄호 제거
        for k in c:
            target[k[0]] = ""
            target[k[1]] = ""
        # 괄호를 제거하고 리스트를 합친 문자열을 정답 리스트에 추가한다.
        answer.add(''.join(target))

for ans in sorted(list(answer)):
    print(ans)