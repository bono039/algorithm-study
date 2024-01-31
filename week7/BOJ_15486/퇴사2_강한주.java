import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] schedule = new int[n+2][n+2]; //i번째 까지 일한 돈은 i+1번째 날에 받기 때문에 +1

        for(int i  = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken()); //상담을 완료하는데 걸리는 기간
            schedule[i][1] = Integer.parseInt(st.nextToken());//상담을 했을 때 받을 수 있는 금액
        }

        int[] dp = new int[n+2]; //dp[i]는 i일까지 일했을 때 버는 최고 수익이다.
        int max = 0; //현재 시점까지 최대 수익

        for(int i = 1; i < n+2; i++){
            if(max < dp[i]){//i일까지의 수익dp[i]가 최대일 때 max값을 갱신한다
                max = dp[i];
            }

            int day = i + schedule[i][0];//i+schedule[i][0] 만큼 상담을 진행한다.즉 다음 상당할 수 있는 날짜
            if(day < n+2){//상담을 진행할 수 있다면 상담 진행
                //현재 날짜까지의 최대 금액 + 현재 상담 금액과
                //상담이 끝난 날짜의 최고 수익과 비교
                dp[day] = Math.max(dp[day],max+schedule[i][1]);
            }

        }

        System.out.println(max);

    }
}

