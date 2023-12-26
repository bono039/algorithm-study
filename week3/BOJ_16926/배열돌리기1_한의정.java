import java.util.*;
import java.io.*;

public class 배열돌리기1_한의정 {
    static int[] dx = {0, 1, 0, -1};   // 서 북 동 남
    static int[] dy = {1, 0, -1, 0};

    static int N, M, R;
    static int min;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Math.min(N, M);   // 행,열 중 더 작은 것 구하기

        // R번 회전시키기
        while(R --> 0) {
            rotate();
        }

        // 출력하기
        print();
    }

    private static void rotate() {
        for(int i = 0 ; i < min / 2 ; i++) {
            int x = i;
            int y = i;

            int lastVal = map[x][y];   // 마지막에 넣을 값 미리 빼놓음

            int idx = 0;

            while(idx < 4) {    // 한 바퀴 다 돌기 전까지
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                if(i <= nx && nx < N - i && i <= ny && ny < M - i) {    // 범위 내에 있으면, 밀어내기
                    map[x][y] = map[nx][ny];
                    x = nx;
                    y = ny;
                }
                else {  // 범위 밖에 있으면, 회전 방향 전환
                    idx++;
                }
            }

            map[i + 1][i] = lastVal;    // 빼놓은 마지막 값 넣기
        }
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for(int[] i : map) {
            for(int j : i) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}