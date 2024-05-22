import java.util.*;
import java.io.*;

public class 배열돌리기4_한의정 {
    static int N,M,K;
    static int[][] map, cycle;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cycle = new int[K][3];  // 회전 연산 정보 배열
        for(int k = 0 ; k < K ; k++) {
            st = new StringTokenizer(br.readLine(), " ");
            cycle[k][0] = Integer.parseInt(st.nextToken()) -1;
            cycle[k][1] = Integer.parseInt(st.nextToken()) -1;
            cycle[k][2] = Integer.parseInt(st.nextToken());
        }

        // 1. 회전 순서 순열 구하기
        perm(0, new int[K], new boolean[K]);    // 순열
        System.out.println(min);
    }

    // 회전 순서 순열 구하는 메소드
    private static void perm(int cnt, int[] arr, boolean[] visited) {
        // [종료 조건] K번만큼 회전 연산을 수행했을 때
        if(cnt == K) {
            rotate(arr);
            return;
        }

        for(int i = 0 ; i < K ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[cnt] = i;   // i번째 회전 연산을 하겠다-
                perm(cnt + 1, arr, visited);
                visited[i] = false;
            }
        }
    }

    // 배열 회전시키는 메소드
    private static void rotate(int[] arr) {
        // 회전시킬 배열 복사하기
        int[][] copy = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                copy[i][j] = map[i][j];
            }
        }

        for(int i = 0 ; i < K ; i++) {
            int r = cycle[arr[i]][0];
            int c = cycle[arr[i]][1];
            int s = cycle[arr[i]][2];

            for(int t = 1 ; t <= s ; t++) {
                // 위
                int upTmp = copy[r-t][c+t];
                for(int y = c+t ; y > c-t ; y--) {
                    copy[r-t][y] = copy[r-t][y-1];
                }

                // 오른쪽
                int rightTmp = copy[r+t][c+t];
                for(int x = r+t ; x > r-t ; x--) {
                    copy[x][c+t] = copy[x-1][c+t];
                }
                copy[r-t+1][c+t] = upTmp;

                // 아래
                int leftTmp = copy[r+t][c-t];
                for(int y = c-t ; y < c+t ; y++) {
                    copy[r+t][y] = copy[r+t][y+1];
                }
                copy[r+t][c+t-1] = rightTmp;

                // 왼쪽
                for(int x = r-t ; x < r+t ; x++) {
                    copy[x][c-t] = copy[x+1][c-t];
                }
                copy[r+t-1][c-t] = leftTmp;
            }
        }

        // 행들의 합 중 최솟값 구하기
        for(int i = 0 ; i < N ; i++) {
            int sum = 0;
            for(int j = 0 ; j < M ; j++) {
                sum += copy[i][j];
            }

            min = Math.min(min, sum);
        }
    }
}