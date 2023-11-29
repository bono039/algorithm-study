n = int(input())
numbers = list(map(int,input().split()))
numbers = sorted(numbers)
min_sum = float('inf')
answer = 0
    
for i in range(1,max(numbers)+1):
    represent_num = i
    sub_list = []
    for number in numbers:
        sub_list.append(abs(represent_num - number))
    sub = sum(sub_list)
    if min_sum == sub:
        break
    if min_sum > sub:
        min_sum = sub
        answer = represent_num
print(answer)
