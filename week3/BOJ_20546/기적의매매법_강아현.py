money = int(input()) # 100
stock = list(map(int,input().split())) # 10 20 23 34 55 30 22 19 12 45 23 44 34 38
def bnp(money, stock):
    jm = money # 준현이의 돈
    js = 0 # 준현이가 보유한 주식의 수
    for price in stock:
        if price <= jm:
            js += (jm//price)
            jm -= ((jm//price) * price)
    return (js * stock[-1]) + jm
def timing(money, stock):
    sm = money # 성민이의 돈
    ss = 0 # 성민이가 보유한 주식의 수
    up = 0 # 주식의 가격이 상승한 일수
    down = 0 # 주식의 가격이 하락한 일수
    for i in range(1,len(stock)):
            if stock[i-1] < stock[i]:
                up += 1
                down = 0
            elif stock[i-1] > stock[i]:
                down += 1
                up = 0
            if up >= 3:
                sm += ss*stock[i]
                ss = 0
            elif down >= 3:
                if stock[i] <= sm:
                    ss += (sm//stock[i])
                    sm -= ((sm//stock[i]) * stock[i])
    return (ss * stock[-1]) + sm

if bnp(money,stock) > timing(money,stock):
    print("BNP")
elif bnp(money,stock) < timing(money,stock):
    print("TIMING")
else:
    print("SAMESAME")