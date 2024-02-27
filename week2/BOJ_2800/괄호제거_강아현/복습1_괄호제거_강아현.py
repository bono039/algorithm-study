from itertools import combinations

s = list(str(input()))
ans, idx, left = set(), [], []

for i in range(len(s)):
    if s[i] == "(": left.append(i)
    elif s[i] == ")": idx.append([left.pop(),i])

for i in range(1,len(idx)+1):
    for j in combinations(idx,i):
        ss = s.copy()
        for c in j:
            ss[c[0]] = ''
            ss[c[1]] = ''
        ans.add(''.join(ss))

print(*sorted(list(ans)),sep='\n')