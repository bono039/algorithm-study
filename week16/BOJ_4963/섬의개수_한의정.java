import java.util.*;
import java.io.*;

public class 섬의개수_한의정 {
    static int[] dx = {-1,1,0,0, -1,-1,1,1};    // 8방향 탐색 (상하좌우 + 대각선 4방향)
    static int[] dy = {0,0,-1,1, -1,1,-1,1};

    static int w,h;
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine(), " ");

            w = Integer.parseInt(st.nextToken());   // 너비 = 열
            h = Integer.parseInt(st.nextToken());   // 높이 = 행

            if(w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            for(int i = 0 ; i < h ; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < w ; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visited = new boolean[h][w];
            int cnt = 0;

            for(int i = 0 ; i < h ; i++) {
                for(int j = 0 ; j < w ; j++) {
                    if(!visited[i][j] && map[i][j] == 1) {  // 방문한 적 없는 땅 탐색
                        bfs(i,j);
                        cnt++;
                    }
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 8 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0 || nx >= h || ny < 0 || ny >= w)  continue;

                if(!visited[nx][ny] && map[nx][ny] == 1) {  // 방문한 적 없는 땅 탐색
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}
