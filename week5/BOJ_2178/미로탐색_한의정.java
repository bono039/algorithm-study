import java.util.*;
import java.io.*;

public class 미로탐색_한의정 {
    // 각 칸에서 4방향 탐색용 dx,dy 배열
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, M;
    static int[][] map;
    static boolean[][] visited; // 방문 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M];
        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();    // 이동할 칸의 좌표값을 저장할 큐
        q.add(new int[] {x, y});

        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            int nowX = now[0];  // 현재 위치의 행
            int nowY = now[1];  // 현재 위치의 열

            // 4방향 탐색을 통해 0이 아니고, 방문한 적 없는 칸이라면 큐에 추가하며 방문한다.
            for(int d = 0 ; d < 4 ; d++) {
                int nx = nowX + dx[d];
                int ny = nowY + dy[d];

                // 범위를 벗어나거나, 0이거나, 방문한 적 있는 칸이면 방문 안 하고 pass
                if(!inRange(nx, ny) || map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                map[nx][ny] = map[nowX][nowY] + 1;  // 현재 칸의 값에 1을 더해 새 칸으로 이동
                q.add(new int[] {nx, ny});
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}
