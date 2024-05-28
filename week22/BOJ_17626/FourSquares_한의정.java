import java.util.*;
import java.io.*;

public class FourSquares_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 2 ; i <= N ; i++) {
            for(int j = 1 ; j * j <= i ; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}
