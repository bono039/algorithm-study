import java.util.*;
import java.io.*;

public class 점프_한의정 {
    static int N;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N+1][N+1];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new long[N+1][N+1];
        dp[0][0] = 1;   // 초기화

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                // 오른쪽 아래 있는 끝점이면 종료
                if(i == N-1 && j == N-1)    continue;

                int val = board[i][j];

                // 오른쪽으로 이동
                if(j + val < N)
                    dp[i][j + val] += dp[i][j];

                // 아래쪽으로 이동
                if(i + val < N)
                    dp[i + val][j] += dp[i][j];
            }
        }

        System.out.println(dp[N-1][N-1]);
    }
}
