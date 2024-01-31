import java.util.*;
import java.io.*;

public class 스티커_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n];
            int[][] dp = new int[2][n];

            for(int i = 0 ; i < 2 ; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j < n ; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 0번 열은 본인이 최대이므로 본인으로 초기화
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];

            for(int i = 1 ; i < n ; i++) {
                if(i == 1) {    // 1번 열은 특수처리
                    dp[0][i] = dp[1][0] + arr[0][1];
                    dp[1][i] = dp[0][0] + arr[1][1];
                    continue;
                }

                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
            }

            sb.append(Math.max(dp[0][n - 1], dp[1][n - 1])).append("\n");
        }

        System.out.println(sb);
    }
}
