import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            //초기화
            int[][] stickers = new int[2][n + 1];
            int[][] dp = new int[2][n + 1]; //dp[i][j] (i,j)까지 스티커를 뗴었을 때 얻을 수 있는 최대 점수
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k < n + 1; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int j = 2; j < n + 1; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2] + stickers[0][j]);
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2] + stickers[1][j]);
            }
            System.out.println(Math.max(dp[0][n],dp[1][n]));
        }

    }