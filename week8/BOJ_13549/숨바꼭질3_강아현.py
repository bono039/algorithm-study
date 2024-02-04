import sys
import heapq
input = sys.stdin.readline
N,K = map(int,input().split())
INF = 2147000000

def dijkstra(N,K):
    dist = [INF]*(100001)
    dist[N] =0 
    hq = []
    heapq.heappush(hq,(0,N))
    while hq:
        w,n = heapq.heappop(hq)
        for nx in [(n+1,1),(n-1,1),(n*2,0)]:
            if 0 <= nx[0] < 100001 and dist[nx[0]] > w + nx[1]:
                dist[nx[0]] = w + nx[1]
                heapq.heappush(hq,(dist[nx[0]],nx[0]))
    print(dist[K])
dijkstra(N,K)