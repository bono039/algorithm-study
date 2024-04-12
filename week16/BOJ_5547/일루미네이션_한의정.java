import java.util.*;
import java.io.*;

public class 일루미네이션_한의정 {
    // 좌, 좌상, 우상, 우, 우하, 좌하
    static int[][] odd = {{0,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}};     // 홀수 행
    static int[][] even = {{0,-1}, {-1,-1}, {-1,0}, {0,1}, {1,0}, {1,-1}};  // 짝수 행

    static int W,H;
    static int[][] map, result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        W = Integer.parseInt(st.nextToken());   // 열
        H = Integer.parseInt(st.nextToken());   // 행

        map = new int[H+2][W+2];
        result = new int[H+2][W+2]; // 인접한 벽 개수 저장 리스트
        visited = new boolean[H+2][W+2];

        for(int i = 1 ; i <= H ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= W ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1)
                    visited[i][j] = true;
            }
        }

        bfs();

        // 각 칸마다 인접한 벽 개수 더해 결과로 출력하기
        int answer = 0;
        for(int i = 0 ; i < H+2 ; i++) {
            for(int j = 0 ; j < W+2 ; j++) {
                answer += result[i][j];
            }
        }

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 6; d++) {   // 맞닿는 6방향 탐색
                int nx = 0;
                int ny = 0;

                if(now[0] % 2 == 1) {	// 홀수 행
                    nx = now[0] + odd[d][0];
                    ny = now[1] + odd[d][1];
                }
                else {	// 짝수 행
                    nx = now[0] + even[d][0];
                    ny = now[1] + even[d][1];
                }

                // 격자 범위 벗어나면 pass
                if(nx < 0 || nx >= H+2 || ny < 0 || ny >= W+2)  continue;

                // 인접한 칸이 벽인 경우
                if(map[nx][ny] == 1) {
                    result[now[0]][now[1]]++;
                    continue;
                }

                // 방문한 적 없고, 인접한 칸이 벽이 아닌 경우
                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
