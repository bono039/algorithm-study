from collections import deque

n = int(input()) # 사진틀의 개수
m = int(input()) # 추천 횟수

recommends = list(map(int,input().split())) # 추천받은 학생
candidates = {} # 학생 번호
pictures = deque() # 사진틀

for recommend in recommends:
    candidates[recommend] = candidates.get(recommend,0) + 1
     # 사진틀에 없는 학생의 경우
    if recommend not in pictures:
        no_picture = 0 # 비어있는 사진틀이 있는지 확인하는 변수
        for i in range(n):
            if len(pictures) < n:
                pictures.append(recommend)
                no_picture = 1
                break
        # 비어있는 사진틀이 없는 경우
        if no_picture == 0:
            cnt = 1000
            now = 0
            # 추천 받은 횟수가 가장 적으면서 오래된 사진을 새로운 사진으로 바꾼다.
            for i in range(n):
                if cnt > candidates[pictures[i]]:
                    cnt = candidates[pictures[i]]
                    now = pictures[i]
            candidates[now] = 0 # 사진이 삭제되는 경우 추천받은 횟수는 0으로 초기화된다.
            pictures.remove(now) # 오래된 사진 제거
            pictures.append(recommend) # 새로운 학생 사진 추가
            
print(*sorted(list(pictures)))