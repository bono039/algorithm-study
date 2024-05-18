import java.util.*;
import java.io.*;

public class 백도어_한의정 {
    static final long INF = Long.MAX_VALUE;

    static int N,M;
    static boolean[] sight; // 시야에 보이는지 여부 나타나는 배열

    static List<Node>[] graph;
    static long[] dist; // 최소 시간 배열
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sight = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            int num = Integer.parseInt(st.nextToken());
            sight[i] = (num == 1) ? false : true;
        }

        // 인접 그래프 초기화
        graph = new ArrayList[N];
        for(int i = 0 ; i < N ; i++)    graph[i] = new ArrayList<>();

        // 최단 거리 배열 가장 큰 값으로 초기화
        dist = new long[N];
        Arrays.fill(dist, INF);

        // 방문 표시 배열 초기화
        visited = new boolean[N];

        // 그래프 정보 입력받기
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            // 양방향
            graph[a].add(new Node(b, t));
            graph[b].add(new Node(a, t));
        }

        dijkstra();
        System.out.println(dist[N-1] == INF ? -1 : dist[N-1]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));

        dist[0] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.e])  continue;
            visited[now.e] = true;

            for(Node next : graph[now.e]) {
                // 상대편 넥서스(N-1번째 분기점)거나 시야에 걸리는 경우 pass
                if(next.e != N-1 && !sight[next.e]) continue;

                // 최단 거리 갱신
                if(dist[next.e] > dist[now.e] + next.v) {
                    dist[next.e] = dist[now.e] + next.v;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int e;
    long v;

    public Node(int e, long v) {
        this.e = e;
        this.v = v;
    }

    // 거리 기준 오름차순 정렬
    @Override
    public int compareTo(Node n) {
        return Long.compare(this.v, n.v);
    }
}