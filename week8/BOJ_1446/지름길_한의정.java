import java.util.*;
import java.io.*;

public class 지름길_한의정 {
    static int N, D;
    static Road[] graph;    // 지름길 배열
    static int[] dist;      // 최단 거리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 지름길 수
        D = Integer.parseInt(st.nextToken()); // 고속도로 길이

        // 최단 거리 배열 초기화
        dist = new int[D + 1];
        for(int i = 0 ; i < dist.length ; i++) {
            dist[i] = i;
        }

        graph = new Road[N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()); // 지름길 시작 위치
            int e = Integer.parseInt(st.nextToken()); // 지름길 도착 위치
            int v = Integer.parseInt(st.nextToken()); // 지름길 길이

            graph[i] = new Road(s, e, v);
        }

        dijkstra(0);
        System.out.println(dist[D]);
    }

    private static void dijkstra(int start) {
        PriorityQueue<Road> pq = new PriorityQueue<>();
        pq.offer(new Road(start, 0, 0));

        dist[start] = 0;    // 시작점-시작점까지의 거리는 0

        while(!pq.isEmpty()) {
            Road cur = pq.poll();
            int nowPos = cur.e; // 현재 위치

            // 현재 위치에서 도달 가능한 도로들 확인
            for(Road r : graph) {
                if(r.s >= nowPos) { // 시작 위치가 종료 위치를 넘었을 때
                    if(r.e > D) continue; // 고속도로 길이 벗어나면 pass

                    // 최단 거리 갱신
                    if(dist[r.e] > dist[nowPos] + r.v + (r.s - nowPos)) {
                        dist[r.e] = dist[nowPos] + r.v + (r.s - nowPos);
                        pq.offer(new Road(nowPos, r.e, dist[r.e]));
                    }
                }
            }

            // 현재 위치에서 고속도로까지의 거리 고려해 최단 거리 갱신
            dist[D] = Math.min(dist[nowPos] + D - nowPos, dist[D]);
        }
    }
}
class Road implements Comparable<Road> {
    int s, e, v;

    public Road(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }

    // 길이 기준 오름차순 정렬
    @Override
    public int compareTo(Road r) {
        return this.v - r.v;
    }
}