import java.io.*;

public class 합분해_한의정 {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int[][] dp = new int[201][201];

        // 초기값 채우기
        for(int i = 1 ; i <= 200 ; i++) {
            dp[i][1] = 1;
            dp[1][i] = i;
        }

        for(int i = 2 ; i <= N ; i++) {
            for(int j = 2 ; j <= K ; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MOD;
            }
        }

        System.out.println(dp[N][K]);
    }
}
