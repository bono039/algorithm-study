sl, sr = map(str,input().split())
word = str(input())
answer = 0

# 키보드 자판
keyboard = [["q","w","e","r","t","y","u","i","o","p"],["a","s","d","f","g","h","j","k","l"],["z","x","c","v","b","n","m"]]

# 처음 왼손 좌표
idx = [[k[0],k[1].index(sl)] for k in enumerate(keyboard) if sl in k[1]]
now_left = [idx[0][0],idx[0][1]]

# 처음 오른손 좌표
idx = [[k[0],k[1].index(sr)] for k in enumerate(keyboard) if sr in k[1]]
now_right = [idx[0][0],idx[0][1]]

for i in range(len(word)):
    s = word[i]
    idx = [[k[0],k[1].index(s)] for k in enumerate(keyboard) if s in k[1]]
    # word의 문자가 한글 자음 쪽 자판인 경우
    # 왼손 좌표 위치를 업데이트
    if s in ["q","w","e","r","t","a","s","d","f","g","z","x","c","v"]:
        answer += (abs(now_left[0]-idx[0][0]) + abs(now_left[1]-idx[0][1]) + 1)
        now_left = [idx[0][0], idx[0][1]]
    
    # word의 문자가 한글 모음 쪽 자판인 경우
    # 오른손 좌표 위치를 업데이트
    elif s in ["y","u","i","o","p","h","j","k","l","b","n","m"]:
        answer += (abs(now_right[0]-idx[0][0]) + abs(now_right[1]-idx[0][1]) + 1)
        now_right = [idx[0][0], idx[0][1]]

print(answer)