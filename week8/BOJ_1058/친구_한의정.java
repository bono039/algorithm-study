import java.util.*;
import java.io.*;

public class 친구_한의정 {
    static final int INF = 9999;

    static int N;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++) {
                if(i == j) {
                    dist[i][j] = INF;
                    continue;
                }

                char ch = str.charAt(j);

                if(ch == 'Y')
                    dist[i][j] = 1;
                else
                    dist[i][j] = INF;
            }
        }

        // 플로이드-워셜 통해 친구 연결 구하기
        for(int k = 0 ; k < N ; k++) {  // 경유지
            for(int i = 0 ; i < N ; i++) {  // 출발지
                for(int j = 0 ; j < N ; j++) {  // 도착지
                    if(i == j || j == k || i == k)  continue;

                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < N ; i++) {
            int cnt = 0;    // 각 사람마다 2-친구 수 구하기

            for(int j = 0 ; j < N ; j++) {
                if(i == j)  continue;   // 본인은 건너뛰기

                if(dist[i][j] <= 2) {   // 2-친구인 경우
                    cnt++;
                }
            }

            max = Math.max(max, cnt);   // 더 큰 값으로 갱신
        }

        System.out.println(max);
    }
}
