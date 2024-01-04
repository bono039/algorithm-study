import java.util.*;
import java.io.*;

public class 효율적인해킹_한의정 {
    static int N, M;
    static List<Integer>[] A;   // 인접 리스트 배열
    static boolean[] visited;   // 방문 배열

    static int maxDepth = -1;   // 최대 해킹 가능한 컴퓨터 수
    static int[] cntArr;        // 노드 별 해킹 컴퓨터 수 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++)   A[i] = new ArrayList<>();

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
        }

        cntArr = new int[N + 1];

        for(int i = 1 ; i <= N ; i++) {
            visited = new boolean[N + 1];   // 매번 초기화해야 함 !
            bfs(i);
        }

        for(int i = 1 ; i <= N ; i++) {
            if(cntArr[i] > maxDepth) {
                maxDepth = cntArr[i];
            }
        }

        for(int i = 1 ; i <= N ; i++) {
            if(maxDepth == cntArr[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(int num) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(num);

        visited[num] = true;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : A[now]) {
                if(!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    cntArr[next]++; // 해킹 가능한 컴퓨터 수 + 1
                }
            }
        }
    }
}
