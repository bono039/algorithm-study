import java.util.*;
import java.io.*;

public class 설탕배달_한의정 {
    static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[5001];

        // dp 배열 초기화
        Arrays.fill(dp, MAX);
        dp[3] = 1;
        dp[5] = 1;

        // N이 5보다 작거나 같은 경우, 그대로 출력
        if(N <= 5) {
            System.out.println(dp[N] == MAX ? -1 : dp[N]);
            return;
        }

        // N이 6 이상인 경우, dp 배열 채우기
        // → MAX가 아닌 j와 (i - j)로 i를 만들 수 있다면 dp[i]를 더 작은 값으로 갱신하기
        for(int i = 6 ; i <= N ; i++) {
            for(int j = 3 ; j <= N - 3 ; j++) {
                if(dp[j] != MAX && dp[i - j] != MAX) {
                    dp[i] = Math.min(dp[i], dp[i - j] + dp[j]);
                }
            }
        }

        System.out.println(dp[N] == MAX ? -1 : dp[N]);
    }
}
