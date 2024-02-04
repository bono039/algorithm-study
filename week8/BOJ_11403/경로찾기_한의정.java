import java.util.*;
import java.io.*;

public class 경로찾기_한의정 {
    static int N;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dist = new int[N + 1][N + 1];
        for(int i = 1 ; i <= N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k = 1 ; k <= N ; k++) { // k : 중간 노드가 될 번호
            for(int i = 1 ; i <= N ; i++) {
                for(int j = 1 ; j <= N ; j++) {
                    // i → k 이동 가능하고, k → j 이동 가능하다면, i → j 이동 가능
                    if(dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j <= N ; j++)
                sb.append(dist[i][j] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
