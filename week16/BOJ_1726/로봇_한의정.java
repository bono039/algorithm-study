import java.util.*;
import java.io.*;

public class 로봇_한의정 {
    static int[] dr = {0,0,1,-1};   // 동서남북
    static int[] dc = {1,-1,0,0};

    static int M,N;
    static int[][] map;
    static boolean[][][] visited;

    static Robot start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N][4];

        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        String[] s1 = br.readLine().split(" ");
        start = new Robot(Integer.parseInt(s1[0]) -1, Integer.parseInt(s1[1]) -1, Integer.parseInt(s1[2]) -1, 0);

        String[] s2 = br.readLine().split(" ");
        end = new Robot(Integer.parseInt(s2[0]) -1, Integer.parseInt(s2[1]) -1, Integer.parseInt(s2[2]) -1, 0);

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Robot> q = new ArrayDeque<>();
        q.add(start);
        visited[start.r][start.c][start.d] = true;

        while(!q.isEmpty()) {
            Robot now = q.poll();

            // 도착지인지 확인
            if(now.r == end.r && now.c == end.c && now.d == end.d) {
                return now.cnt;
            }

            for(int i = 1 ; i <= 3 ; i++) {
                int nr = now.r + dr[now.d]*i;
                int nc = now.c + dc[now.d]*i;

                if(nr < 0 || nr >= M || nc < 0 || nc >= N)  continue;

                // 중간에 벽이 있으면 아예 끝
                if(map[nr][nc] == 1) break;

                if(!visited[nr][nc][now.d]) {
                    visited[nr][nc][now.d] = true;
                    q.add(new Robot(nr, nc, now.d, now.cnt +1));
                }
            }

            int left = 0;   // 왼쪽   90도 회전: 동0 > 북3> 서1> 남2
            int right = 0;  // 오른쪽 90도 회전: 동0 > 남2 > 서1> 북3

            switch(now.d) {
                case 0: left = 3; right = 2; break;
                case 1: left = 2; right = 3; break;
                case 2: left = 0; right = 1; break;
                case 3: left = 1; right = 0; break;
            }

            if(!visited[now.r][now.c][left]) {
                visited[now.r][now.c][left] = true;
                q.add(new Robot(now.r, now.c, left, now.cnt +1));
            }

            if(!visited[now.r][now.c][right]) {
                visited[now.r][now.c][right] = true;
                q.add(new Robot(now.r, now.c, right, now.cnt +1));
            }
        }

        return -1;
    }
}

class Robot {
    int r,c,d,cnt;

    public Robot(int r, int c, int d, int cnt) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.cnt = cnt;
    }
}
