n, tscore, p = map(int,input().split())
if n > 0:
    scores = sorted(list(map(int,input().split())),reverse=True)
    if tscore <= min(scores) and n == p:
        print(-1)
    else:
        rank = []
        i = 1
        k = 0
        for score in sorted(scores+[tscore],reverse=True):
            k += 1
            if rank:
                if rank[-1][1] > score:
                    i += 1
                    rank.append((k,score))
                    i = k
                elif rank[-1][1] == score:
                    rank.append((i,score))
            else:
                rank.append((i,score))
            if score == tscore:
                print(rank[-1][0])
                break
else:
    print(1)