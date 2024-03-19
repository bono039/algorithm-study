import java.util.*;
import java.io.*;

public class LCS_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();

        int R = c1.length;
        int C = c2.length;

        int[][] dp = new int[R+1][C+1];

        for(int i = 1 ; i <= R ; i++) {
            for(int j = 1 ; j <= C ; j++) {
                if(c1[i-1] == c2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;    // 대각선에 있는 값
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);    // 왼쪽 값과 윗 칸 중 더 큰 값으로
            }
        }

        System.out.println(dp[R][C]);
    }
}
