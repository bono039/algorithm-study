import java.util.*;
import java.io.*;

public class 카드구매하기_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N + 1];
        int[] dp = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                // 카드 i개 구매 방법 : 카드 j개가 들어있는 카드팩 구매하고, 카드 i-j개 구입
                dp[i] = Math.max(dp[i], P[j] + dp[i-j]);
            }
        }

        System.out.println(dp[N]);
    }
}
