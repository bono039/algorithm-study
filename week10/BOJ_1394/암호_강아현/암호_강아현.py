def solve():
    alpha = input()
    computer_pw = input()
    alpha_len, computer_pw_len = len(alpha), len(computer_pw)
    count, powers = 0, 1

    # 미리 계산한 alpha의 인덱스를 저장
    alpha_index = {char: i for i, char in enumerate(alpha)}

    for i in range(computer_pw_len - 1, -1, -1):
        count += powers * (alpha_index[computer_pw[i]] + 1)
        count %= 900528  # 중간 결과에서 모듈러 연산을 수행

        powers *= alpha_len
        powers %= 900528  # 중간 결과에서 모듈러 연산을 수행

    print(count)

if __name__ == "__main__":
    solve()