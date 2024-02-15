import java.util.*;
import java.io.*;

public class 과일서리_한의정 {
    static int N, M;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 과일 종류
        M = Integer.parseInt(br.readLine());    // 훔치려 하는 과일 갯수

        dp = new int[M + 1][M + 1]; // dp[i][j] : 과일 j종 중 i개 뽑는 경우의 수

        // 초기값 채우기
        for(int i = 1 ; i <= M ; i++) {
            dp[i][i] = 1;   // 과일 i종 중 중 i개 뽑는 경우의 수 = 1
            dp[i][1] = 1;   // 과일 1종 중 i개 뽑는 경우의 수 = 1
        }

        for(int i = 1 ; i <= M ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                if(i == j)  continue;

                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        System.out.println(dp[M][N]);
    }
}
