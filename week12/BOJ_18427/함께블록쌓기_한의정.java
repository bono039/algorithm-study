import java.util.*;
import java.io.*;

public class 함께블록쌓기_한의정 {
    static final int MOD = 10007;

    static int N,M,H;
    static int[][] dp;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 학생 수
        M = Integer.parseInt(st.nextToken());   // 블록 수
        H = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];

        for(int i = 1 ; i <= N ; i++) {
            list[i] = new ArrayList<>();

            String[] str = br.readLine().split(" ");
            for(String s : str) {
                int num = Integer.parseInt(s);
                list[i].add(num);
            }
        }

        dp = new int[N+1][1001];
        for(int i = 0 ; i <= N ; i++)   // 아무것도 쌓지 않은 경우의 수는 1로 초기화
            dp[i][0] = 1;

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= H ; j++) {
                for(int num : list[i]) {
                    // i번째 학생이 k번째 블록을 선택하는 경우
                    if(j >= num) {  // 내가 가진 블록값 + 이전까지 만든 블록 값
                        dp[i][j] += dp[i-1][j - num];   // 이전까지 만든 경우의 수 더하기
                        dp[i][j] %= MOD;
                    }
                }

                // i번째 학생이 블록을 사용하지 않는 경우
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= MOD;
            }
        }

        System.out.println(dp[N][H]);
    }
}
