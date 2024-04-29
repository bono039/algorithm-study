import java.util.*;
import java.io.*;

public class 파일합치기_한의정 {
    static int T;
    static int[] sum = new int[501];        // 파일 비용 합 저장 배열 (누적합)
    static int[][] dp = new int[501][501];  // j → i 합치는 최소 비용 저장

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++) {
            int K = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= K ; j++) {
                sum[j] = sum[j-1] + Integer.parseInt(st.nextToken());
            }

            solve(K);
            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb.toString());
    }

    // 파일 최소 비용 구하는 함수 (dp[1][2] ~ dp[1][k]까지 계산)
    private static void solve(int k) {
        for(int to = 2 ; to <= k ; to++) {                // 목적지 (몇 장 묶을건지)
            for(int from = to-1 ; from >= 1 ; from--) {   // 출발지 (어디서부터 묶을건지)
                dp[from][to] = Integer.MAX_VALUE;

                for(int x = from ; x < to ; x++) {  // 특정 지점으로 나눠서 최대값 구하기
                    dp[from][to] = Math.min(dp[from][to], dp[from][x] + dp[x+1][to]);
                }

                dp[from][to] += sum[to] - sum[from - 1];    // 비용 합 더하기
            }
        }
    }
}