import java.util.*;
import java.io.*;

public class 플로이드_한의정 {
    static final int INF = 987654321;   // 100 * 100000보다 큰 수면 다 괜찮음

    static int N,M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(i != j)
                    dp[i][j] = INF;
            }
        }

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken());

            dp[a][b] = Math.min(dp[a][b], c);   // 새로 입력받은 값과 기존 값 중 더 작은 값 넣기
        }

        // 플로이드-워셜
        for(int k = 0 ; k < N ; k++) {  // 경유지
            for(int i = 0 ; i < N ; i++) {  // 출발지
                for(int j = 0 ; j < N ; j++) {  // 도착지
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                sb.append(dp[i][j] == INF ? 0 : dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
