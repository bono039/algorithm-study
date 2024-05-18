import java.util.*;
import java.io.*;

public class 최소비용구하기_한의정 {
    static long INF = Long.MAX_VALUE;

    static int N,M, start, end;
    static List<Node>[] graph;  // 인접 리스트
    static boolean[] visited;   // 방문 표시 배열

    static long[] dist; // 최단 거리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 초기화
        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++)   graph[i] = new ArrayList<>();

        dist = new long[N+1];
        Arrays.fill(dist, INF);

        visited = new boolean[N+1];

        // 입력 받기
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, v));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(dist[end]);
    }

    private static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.idx])    continue;
            visited[now.idx] = true;

            // 연결된 다음 정점으롱 이동
            for(Node next : graph[now.idx]) {
                if(dist[next.idx] > dist[now.idx] + next.v) {   // 최단 거리 갱신
                    dist[next.idx] = dist[now.idx] + next.v;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int idx;
    long v;

    public Node(int idx, long v) {
        this.idx = idx;
        this.v = v;
    }

    // 거리 기준 오름차순 정렬
    @Override
    public int compareTo(Node n) {
        return Long.compare(this.v, n.v);
    }
}
