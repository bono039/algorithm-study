import java.util.*;
import java.io.*;

public class 케빈베이컨의6단계법칙_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());   // 유저 수
        int M = Integer.parseInt(st.nextToken());   // 친구 관계 수

        int[][] dp = new int[N+1][N+1];

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 양방향
            dp[a][b] = 1;
            dp[b][a] = 1;
        }

        // [플로이드-워셜] dp 배열 채우기
        for(int k = 1 ; k <= N ; k++) { // 경유지
            for(int i = 1 ; i <= N ; i++) { // 출발지
                for(int j = 1 ; j <= N ; j++) { // 도착지
                    if(i==j || j==k || k==i)    continue;

                    if(dp[i][k] != 0 && dp[k][j] != 0) {    // 출발지와 도착지를 연결하는 경유지가 있으면
                        if(dp[i][j] == 0)   // 친구 관계가 없으면 값 그대로 넣기
                            dp[i][j] = dp[i][k] + dp[k][j];
                        else    // 이미 친구 관계가 있다면, 더 작은 케빈 베이컨 수 넣기
                            dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
        }

        int min = 5000; // 최소 케빈 베이컨 수
        int answer = 0; // 번호가 가장 작은 사람

        for(int i = 1 ; i <= N ; i++) {
            int tmp = 0;

            for(int j = 1 ; j <= N ; j++) {
                if(i != j)
                    tmp += dp[i][j];
            }

            if(tmp < min) {
                min = tmp;
                answer = i;
            }
        }
        System.out.println(answer);
    }
}
