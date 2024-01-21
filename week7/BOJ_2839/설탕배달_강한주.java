import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] dp = new int[n+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+5];//무게가 n일때 최소 봉지 수를 기록하는 dp

        dp[0] = -1;
        dp[1]= -1;dp[2]= -1;
        dp[3] = 1; dp[5] = 1;
        dp[4] = -1; dp[7] = -1;
        dp[6] = 2;

        for(int i = 8; i <= n; i++){
            if(dp[i-3] >= 0 && dp[i-5] >= 0){
                dp[i] = Math.min(dp[i-5]+1,dp[i-3]+1);
            }else if(dp[i-3] > 0){//3키로 짜리로 배달 가능하면
                dp[i] = dp[i-3] + 1;
            }else if(dp[i-5] > 0){//5키로 짜리로 배달 가능하면
                dp[i] = dp[i-5] + 1;
            }else{//3,5키로 둘다 배달 불가능할 경우
                dp[i] = -1;
            }

        }

        System.out.println(dp[n]);
    }

}