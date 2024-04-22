import java.io.*;

public class 일로만들기_한의정 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[1] = 0;

        for(int i = 2 ; i <= N ; i++) {
            dp[i] = dp[i-1] + 1;    // -1 먼저 하기

            if(i % 3 == 0)  dp[i] = Math.min(dp[i], dp[i/3] + 1);   // %3 연산
            if(i % 2 == 0)  dp[i] = Math.min(dp[i], dp[i/2] + 1);   // %2 연산
        }

        System.out.println(dp[N]);
    }
}
