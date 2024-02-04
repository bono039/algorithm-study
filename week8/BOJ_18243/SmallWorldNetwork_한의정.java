import java.util.*;
import java.io.*;

public class SmallWorldNetwork_한의정 {
    static final int INF = Integer.MAX_VALUE;

    static int N, K;
    static int[][] dist;    // 최단 거리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 최단 거리 배열 초기화
        dist = new int[N + 1][N + 1];
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++) {
                if(i == j) continue;
                dist[i][j] = INF;
            }
        }

        while(K --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for(int k = 1 ; k <= N ; k++) {
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    if(i == j || j == k || i == k)  continue;   // 셋 중 둘이 같으면 pass

                    if(dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j < i ; j++) {
                if(i == j)  continue;

                if(dist[i][j] == INF || dist[i][j] > 6) {
                    System.out.println("Big World!");
                    return;
                }
            }
        }

        System.out.println("Small World!");
    }
}
