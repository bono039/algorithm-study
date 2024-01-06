import java.util.*;
import java.io.*;

public class 토마토_한의정 {
    // 토마토의 인접한 방향 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int M, N;
    static int[][] map;

    static Queue<int[]> q = new ArrayDeque<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 1) {    // 토마토가 익은 칸을 큐에 추가
                    q.add(new int[] {i, j});
                }
            }
        }

        bfs();

        // 완전탐색으로 모든 토마토가 익었는지, 모두 익었다면 익히는 날짜 구하기
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] == 0) {    // 토마토가 익지 않은 칸이 있다면, -1 출력하고 종료
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, map[i][j]); // 토마토가 익을 때까지의 날짜 구하기
            }
        }

        // 저장될 때부터 모든 토마토가 익어있다면 최댓값이 1이므로 0을, 그게 아니라면 계산한 날짜 - 1을 출력한다.
        System.out.println(max == 1 ? 0 : max - 1);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();

            // 익은 토마토의 인접한 4방향 탐색
            for(int d = 0 ;d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(!inRange(nx, ny))    continue;

                if(map[nx][ny] == 0) {  // 토마토가 익지 않은 칸이라면 익히기
                    map[nx][ny] = map[now[0]][now[1]] + 1;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}
