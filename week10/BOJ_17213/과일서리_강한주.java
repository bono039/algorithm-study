import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int[][] dp = new int[11][31];//dp[i][j] : i종류를 j개 훔칠 수 있는 경우의 수

        for(int i = 1; i <= m; i++) {
            dp[1][i] = 1; //1종류의 과일을 i개 훔칠 수 있는 방법은 단 1가지 이다.
        }

        for(int i = 1; i <= n; i++) {
            dp[i][i] = 1; //i종류의 과일을 i개 훔칠 수 있는 방법도 단 1가지다.
        }

        for(int i = 2; i <= n; i++) {
            for(int j = i; j <= m; j++) {//과일의 종류당 최소 1개는 훔쳐야 하므로 j = i부터 시작하는 것.
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1]; //다음과 같은 점화식이 세워진다
            }
        }

        System.out.println(dp[n][m]);

    }
}