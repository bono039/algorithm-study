N = int(input())
numbers = sorted(list(map(int,input().split())))
# numbers 내 모든 자연수들의 차이 합을 담은 리스트
min_diff = [sum([abs(i-j) for j in numbers]) for i in numbers]
# 대표 자연수 : 차이 합이 가장 작은 자연수
min_represent_num = numbers[min_diff.index(min(min_diff))]
print(min_represent_num)