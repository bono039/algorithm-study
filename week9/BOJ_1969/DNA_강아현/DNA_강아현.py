from collections import Counter

N, M = map(int,input().split())
DNA = [str(input()) for _ in range(N)]
s, hamming_dist = '', N*M

for i in range(M):
    a = sorted(Counter([j[i] for j in DNA]).items(),key=lambda x:(-x[1],x[0]))
    s, hamming_dist = s + a[0][0], hamming_dist - a[0][1]
print(s,hamming_dist,sep='\n')