import java.util.*;
import java.io.*;

public class DFS와BFS_한의정 {
    static int N;
    static ArrayList<Integer>[] tree;   // 인접 리스트
    static boolean[] visited;           // 방문 배열
    static int[] parent;                // 부모 노드 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 인접 리스트 배열 초기화
        tree = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            tree[i] = new ArrayList<>();
        }

        // N-1번 입력받기
        for(int i = 1 ; i < N ; i++) {
            String[] str = br.readLine().split(" ");

            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            // 양방향 연결
            tree[a].add(b);
            tree[b].add(a);
        }

        visited = new boolean[N + 1];
        parent = new int[N + 1];
        bfs(1);
        print();
    }

    private static void bfs(int num) {
        visited[num] = true;

        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : tree[now]) { // 현재 정점과 연결된 정점 리스트 돌기
                if(!visited[next]) {
                    visited[next] = true;
                    parent[next] = now;     // 부모 노드를 배열에 저장
                    q.add(next);
                }
            }
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i = 2 ; i <= N ; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}
