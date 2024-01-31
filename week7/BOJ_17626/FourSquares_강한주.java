import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];//dp[i] : i를 제곱수 합으로 표현할때 쓴 최소의 수(4이하의 자연수)
        dp[1] = 1; //초기 상태 1은 1^2로 1개의 수로 표현 가능

        int min = 0;
        for(int i = 2; i <= n; i++){
            min = Integer.MAX_VALUE;

            for(int j = 1; j*j <= i; j++){//i보다 작거나 같은 제곱수는 j가 있다 예)i=4면 제곱수 1,2가 있다
                int temp = i - j*j;
                min = Math.min(min,dp[temp]);
            }

            dp[i] = min + 1;//dp[i] = min(dp[i-j*j])+1 이라는 점화식을 세울 줄 알아야 한다
        }

        System.out.println(dp[n]);


    }
}
