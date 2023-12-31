sound = list(str(input()))
duck_sound = "quack" # 올바른 오리의 소리
ducks = [] # 오리가 몇 마리 있는지 세기 위한 리스트
for i in range(1,sound.count("q")+1): # 입력받은 문자열에서 오리는 최대로 'q'의 수만큼 있을 것이다.
    t = 0
    # sound에서 i번에 해당하는 오리가 정상적인 소리를 내는지 확인
    for s in range(len(sound)):
        if t == 5: t = 0
        if duck_sound[t] == sound[s]:
            sound[s] = i
            t += 1
    # i번째 오리가 올바르게 소리를 내는 것이 sound의 마지막 소리 이 전에 끝나는 경우
    if t == 0 and i != sound[-1] and i in sound:
        ducks.append(i)
    # i번째 오리가 올바르게 소리를 내는 것이 sound의 마지막 소리에서 끝나는 경우
    elif t == 5:
        ducks.append(i)
# sound에는 몇 번째 오리가 우는 지 모두 표시를 해놨기 때문에
# 오리의 번호를 담은 리스트와 sound의 원소의 중복제거 값이 같으면
# 모든 오리가 올바르게 소리를 낸 것이다.
temp = set(sound)
if list(temp) == ducks:
    print(max(ducks))
else:
    print(-1)