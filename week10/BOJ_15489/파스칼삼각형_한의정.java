import java.util.*;
import java.io.*;

public class 파스칼삼각형_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());   // 행
        int C = Integer.parseInt(st.nextToken());   // 열
        int W = Integer.parseInt(st.nextToken());   // 정삼각형 변 길이

        int[][] dp = new int[R + W][R + W];

        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                if(i == j || j == 1)    // 행 번호=열 번호거나 1번째 열인 경우, 1로 채우기
                    dp[i][j] = 1;
                else    // 그 외 나머지 칸은 조합으로 채우기
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        int sum = 0;
        int tmp = 0;
        for(int i = R ; i < R + W ; i++) {
            tmp = i - R;    // j의 범위를 삼각형 모양으로 제한하기 위한 변수

            for(int j = C ; j < C + W ; j++) {
                if(R <= i && i < R + W && C <= j && j <= C + tmp) {
                    sum += dp[i][j];
                }
            }
        }

        System.out.println(sum);
    }
}
