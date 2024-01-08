import java.util.*;
import java.io.*;

public class 바이러스_한의정 {
    static int N, M;
    
    static ArrayList<Integer>[] A;  // 인접 리스트
    static boolean[] visited;
    
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 인접 리스트 초기화
        A = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++) {
            A[i] = new ArrayList<>();
        }

        while(M --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        visited = new boolean[N + 1];
        dfs(1);

        System.out.println(cnt);
    }

    private static void dfs(int num) {
        visited[num] = true;

        for(int x : A[num]) {
            if(visited[x])  continue;

            cnt++;
            dfs(x);
        }
    }
}
