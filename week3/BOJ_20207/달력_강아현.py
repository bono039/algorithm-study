n = int(input())
schedules = [] # 일정
for _ in range(n):
    schedules.append(list(map(int,input().split())))
min_day = min(map(min,schedules))
max_day = max(map(max,schedules))

calender = [0 for _ in range(min_day, max_day+1)] # 달력
# 달력은 일정에서 제일 빨리 있는 일정부터 제일 늦게 있는 일정까지의 범위로 설정한다.
for schedule in schedules:
    for i in range(schedule[0],schedule[1]+1):
        calender[i-min_day] += 1

# 코팅지의 가로/세로 길이
width, height = 0, 0 
# 코팅지의 면적
paper = 0 

for i in range(len(calender)):
    # 일정이 하나라도 있는 날
    if calender[i] != 0: 
        width += 1
        if height < calender[i]:
            height = calender[i]
        if i == len(calender)-1:
            paper += (width*height)
    # 일정이 하나도 없는 날
    elif calender[i] == 0: 
        paper += (width*height)
        width = 0
        height = 0
print(paper)