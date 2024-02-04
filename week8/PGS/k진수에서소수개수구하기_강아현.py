def solution(n, k):
    turnTok = int(str(n),10)
    str_n = ''
    answer = 0
    # 10진수 -> 3진수
    while turnTok > 0:
        turnTok, b = divmod(turnTok,k)
        str_n += str(b)
    str_n = str_n[::-1]
    # 3진수로 변환한 리스트를 0을 기준으로 자른다.
    str_list = list(str_n.split('0'))
    # str_list 내 소수의 개수 구하기
    for i in range(len(str_list)):
        a = 0
        if str_list[i] != "":
            for t in range(2,int(int(str_list[i])**0.5)+1):
                if int(str_list[i]) % t == 0:
                    a += 1
            if a == 0:
                answer += 1
    # 1은 소수가 아니므로 1의 개수를 뺀다.
    answer = answer - str_list.count('1')
    return answer