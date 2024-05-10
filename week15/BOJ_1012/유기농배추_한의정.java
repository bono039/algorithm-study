import java.util.*;
import java.io.*;

public class 유기농배추_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int T,N,M,K;
    static int[][] board;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());   // 가로 = 열
            N = Integer.parseInt(st.nextToken());   // 세로 = 행
            K = Integer.parseInt(st.nextToken());   // 배추 심어진 위치 개수

            board = new int[N][M];
            visited = new boolean[N][M];

            int cnt = 0;

            while(K --> 0) {
                String[] str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]);
                int y = Integer.parseInt(str[1]);

                board[y][x] = 1;
            }

            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < M ; j++) {
                    if(!visited[i][j] && board[i][j] == 1) {
                        bfs(i, j);
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

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(0 > nx || nx >= N || 0 > ny || ny >= M)  continue;

                if(!visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
