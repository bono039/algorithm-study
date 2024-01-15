n = int(input())
star_n = n*2+(2*(n-2)+1)
star = ['*' for _ in range(star_n)]
no_star = ['0' for _ in range(star_n)]
left, right = 0, star_n - 1
lr = 0
for i in range(star_n):
    if i%2 == 0: # 홀수번째
        if left - 1 >= 0 and right + 1 < star_n-1 and lr == 0:
            star[left-1] = ' '
            star[right+1] = ' '
        elif left + 3 < star_n-1 and right - 3  >= 0 and lr == 1:
            star[left+3] = '*'
            star[right-3] = '*'
        print(*star, sep='')
    else:
        if left == right:
            lr = 1
            left -= 2
            right += 2
        no_star[left] = '*'
        no_star[left+1:right] = ' '*(right-left-1)
        no_star[right] = '*'
        if lr == 0:
            left += 2
            right -= 2
        elif lr == 1:
            left -= 2
            right += 2
        print(*no_star, sep='')