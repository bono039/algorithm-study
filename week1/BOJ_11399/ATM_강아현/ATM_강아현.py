# ATM 이용자 수 input
n = int(input())
# ATM 이용자들의 돈 인출 소요 시간 리스트
time_n = list(map(int,input().split()))
# 먼저 인출하는 사람의 소요 시간이 적어야
# 이어서 이용하는 사람들의 누적 소요 시간이 적어지기 때문에
# 시간 리스트를 오름차순으로 정렬
time_n = sorted(time_n)
answer = 0

for i in range(n):
    take_time = 0
    for j in range(i+1):
        take_time += time_n[j]
    answer += take_time
print(answer)