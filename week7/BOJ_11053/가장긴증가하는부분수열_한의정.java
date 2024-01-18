import java.util.*;
import java.io.*;

public class 가장긴증가하는부분수열_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, 1); // dp 배열의 모든 값 1로 초기화

        int max = 1;    // 초기값 1 !!!

        for(int i = 0 ; i < N ; i++) {      // i 범위 : 0 ~ N - 1
            for(int j = 0 ; j < i ; j++) {  // j 범위 : 0 ~ i - 1
                if(A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(max);
    }
}
