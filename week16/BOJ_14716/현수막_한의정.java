import java.util.*;
import java.io.*;

public class 현수막_한의정 {
    static int[] dx = {-1,1,0,0, -1,-1,1,1};	// 8방향 (상하좌우 + 대각선 4방향)
    static int[] dy = {0,0,-1,1, -1,1,-1,1};

    static int M,N;
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visited[i][j] && map[i][j] == 1) {	// 방문한 적 없는 글자인 부분 탐색
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    // BFS
    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 8 ; d++) {  // 8방향 탐색
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N)  continue;
                if(!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}
