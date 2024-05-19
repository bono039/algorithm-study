import java.util.*;
import java.io.*;

public class 플레이리스트_한의정 {
    static final int MOD = 1_000_000_007;
    
    static int N,M,P;
    static long[][] dp = new long[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        // dp[i][j] : i개의 음악을 플리에 넣고, j개의 음악 종류를 사용했을 때의 경우의 수
        dp[0][0] = 1;

        for(int musicNum = 1 ; musicNum <= P ; musicNum++) {
            for(int savedMusicNum = 0 ; savedMusicNum <= N ; savedMusicNum++) {
                if(savedMusicNum > 0) { // 1) 플리에 넣지 않은 음악인 경우
                    dp[musicNum][savedMusicNum] += dp[musicNum-1][savedMusicNum-1] * (N - savedMusicNum + 1);
                    dp[musicNum][savedMusicNum] %= MOD;
                }
                if(savedMusicNum > M) { // 2) 플리에 넣은 음악인 경우
                    dp[musicNum][savedMusicNum] += dp[musicNum-1][savedMusicNum] * (savedMusicNum - M);
                    dp[musicNum][savedMusicNum] %= MOD;
                }
            }
        }

        System.out.println(dp[P][N]);
    }
}