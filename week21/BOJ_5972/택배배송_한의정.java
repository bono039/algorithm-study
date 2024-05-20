import java.util.*;
import java.io.*;

public class 택배배송_한의정 {
    static int N,M;
    static List<Node>[] graph;  // 인접 리스트
    static int[] dist;          // 최소 여물 배열
    static boolean[] visited;   // 방문 표시 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 초기화 - 인접 리스트, 최소 여물 배열, 방문 표시 배열
        graph = new ArrayList[N+1];
        for(int i = 1 ; i <= N ; i++)   graph[i] = new ArrayList<>();

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE); // 5만 * 1000 +1 이상의 큰 수로 초기화

        visited = new boolean[N+1];

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 양방향
            graph[a].add(new Node(b,c));
            graph[b].add(new Node(a,c));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        dist[1] = 0; // 시작 노드
        while(!pq.isEmpty())         {
            Node now = pq.poll();

            if(visited[now.e])  continue;
            visited[now.e] = true;

            for(Node next : graph[now.e]) {
                if(dist[next.e] > dist[now.e] + next.v) {   // 최소 여물 갱신
                    dist[next.e] = dist[now.e] + next.v;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }

        return dist[N];
    }
}
class Node implements Comparable<Node> {
    int e, v;

    public Node(int e, int v) {
        this.e = e;
        this.v = v;
    }

    // 여물 비용 기준 오름차순 정렬
    @Override
    public int compareTo(Node n) {
        return this.v - n.v;
    }
}