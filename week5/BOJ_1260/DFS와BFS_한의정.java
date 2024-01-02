import java.util.*;
import java.io.*;

public class DFS와BFS_한의정 {
    static int N, M, V;

    static ArrayList<Integer>[] A;  // 인접 리스트
    static boolean[] visited;       // 방문 배열

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향으로 저장
            A[a].add(b);
            A[b].add(a);
        }

        // 작은 점부터 순서대로 방문하도록 오름차순 정렬
        for(int i = 1 ; i <= N ; i++) {
            Collections.sort(A[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb.toString());
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        sb.append(idx + " ");

        for(int next : A[idx]) {    // 해당 정점과 연결된 정점 중 방문하지 않은 점 방문하러 감
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int idx) {
        visited[idx] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(idx);

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now + " ");

            for(int next : A[now]) {    // 해당 정점과 연결된 정점 중 방문하지 않은 점 방문하러 감
                if(!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
}
