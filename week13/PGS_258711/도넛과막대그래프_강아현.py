from collections import defaultdict

def solution(edges):
    answer = [0,0,0,0]
    dic = defaultdict(lambda:[0,0])

    for i, j in edges:
        dic[i][0] += 1 # 나가는 간선
        dic[j][1] += 1 # 들어오는 간선

    for node, item in dic.items():
        out_ = item[0]
        in_ = item[1]
        # 생성된 정점은 나가는 간선만 있고 들어오는 간선은 없음
        if out_ >= 2 and in_ == 0: answer[0] = node
        # 8자 모양 그래프는 들어오고 나가는 간선이 최소 2개이상 있어야 함
        elif out_ >= 2 and in_ >= 2: answer[3] += 1
        # 막대 모양 그래프는 나가는 간선은 없고 들어오는 간선이 최소 1개 이상 있어야 함
        elif out_ == 0 and in_ >= 1: answer[2] += 1

    t = dic[answer[0]][0]
    # 도넛 모양 그래프는 생성된 정점에 연결된 정점의 개수에서 8자 모양,막대 모양 그래프의 수를 빼면 됨
    answer[1] = t - answer[2] - answer[3]

    return answer