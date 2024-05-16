import java.io.*;

public class 더하기5_한의정 {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[][] dp = new long[100_001][4];

        dp[1][1] = 1;	// 1
        dp[2][2] = 1;	// 2
        dp[3][1] = 1;	// 2+1
        dp[3][2] = 1;	// 1+2
        dp[3][3] = 1;	// 3

        for(int i = 4 ; i <= 100_000 ; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        while(T --> 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append((dp[num][1] + dp[num][2] + dp[num][3]) % MOD).append("\n");
        }
        System.out.println(sb.toString());
    }
}
