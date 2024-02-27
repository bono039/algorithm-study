import sys

n = int(input())
# 회의 리스트
meetings = []
for _ in range(n):
    meetings.append(list(map(int,input().split())))
# 회의가 끝나는 시간을 기준으로 먼저 정렬 후,
# 회의가 시작하는 시간으로 정렬한다.
meetings.sort(key = lambda x:(x[1],x[0]))

now = 0 # 회의가 끝나고 나서의 시간
cnt = 0 # 정답값

for meet in meetings:
    if meet[0] >= now:
        now = meet[1]
        cnt += 1
print(cnt)