s = str(input())
tag = []
reverse_s = "" # 뒤집은 단어
reverse = ""
for i in range(len(s)):
    if s[i] == "<": # 태그 열기
        tag.append(s[i])
        # <태그> 사이에 단어가 있는 경우 <태그>
        if reverse != "":
            rev = list(reverse.split())
            for j in range(len(rev)):
                rev[j] = rev[j][::-1]
            reverse_s += (' '.join(rev))
            reverse = ""
        reverse_s += "<"
    elif s[i] == ">": # 태그 닫기
        tag.pop()
        reverse_s += ">"
    else:
        if tag == [] and i != len(s)-1:
            reverse += s[i]
        elif tag == [] and i == len(s)-1:
            reverse += s[i]
            rev = list(reverse.split())
            for j in range(len(rev)):
                rev[j] = rev[j][::-1]
            reverse_s += (' '.join(rev))
        elif tag != []: # 태그 괄호 안에 있는 문자는 뒤집지 않고 그대로 출력
            reverse_s += s[i]
print(reverse_s)