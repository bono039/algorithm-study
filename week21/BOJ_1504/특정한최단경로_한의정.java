import java.util.*;
import java.io.*;

public class 특정한최단경로_한의정 {
    static int INF = 200000*100;    // 간선 최대 개수 E * 가중치 최댓값 c (Integer.MAX_VALUE로 하면 오버플로우 발생)

    static int N,E;
    static List<Node>[] list;
    static int[] dist;  // 시작점에서 각 정점으로 가는 최단 거리
    static boolean[] visited;   // 방문 표시 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++)   list[i] = new ArrayList<>();

        dist = new int[N+1];
        visited = new boolean[N+1];

        while(E --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 경로1) 1 > v1 > v2 > N
        int ans1 = 0;
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, N);

        // 경로2) 1 > v2 > v1 > N
        int ans2 = 0;
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, N);

        int answer = 0;
        answer = (ans1 >= INF && ans2 >= INF) ? -1 : Math.min(ans1, ans2);
        System.out.println(answer);
    }

    // 다익스트라
    private static int dijkstra(int start, int end) {
        // 방문 표시 배열과 거리 배열은 매번 초기화하기
        Arrays.fill(visited, false);
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        dist[start] = 0;    // 시작점 거리 0으로 세팅

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.e])  continue;   // 방문했던 정점은 pass
            visited[now.e] = true;

            // 현재 노드에 연결된 다른 노드 탐색
            for(Node next : list[now.e]) {
                if(dist[next.e] > now.v + next.v) { // 더 작은 경로로 이동
                    dist[next.e] = now.v + next.v;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        return dist[end];   // 목적지 end까지의 최단 거리
    }
}

class Node implements Comparable<Node> {
    int e, v;   // 목적지, 거리

    public Node(int e, int v) {
        this.e = e;
        this.v = v;
    }

    // 거리 기준 오름차순 정렬
    @Override
    public int compareTo(Node n) {
        return this.v - n.v;
    }
}