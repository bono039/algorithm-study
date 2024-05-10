import java.util.*;
import java.io.*;

public class 벽부수고이동하기_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;   // 부서짐 여부 (1: 부서짐), 행, 열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == 1 && M == 1) {  // 이거 빠뜨리면 97%에서 틀림
            System.out.println(1);
            return;
        }

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0,0});  // 행, 열, 부숴짐 여부 (1: 부서짐)

        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];
            int crashed = now[2];

            for(int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;

                if(map[nx][ny] == 1) {  // 벽인 경우
                    if(crashed == 0 && !visited[1][nx][ny]) {    // 부수지 않고, 방문한 적 없는 벽인 경우
                        visited[crashed][nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        q.add(new int[] {nx, ny, 1}); // 1: 벽 부숨
                    }
                }
                else {  // 빈 칸인 경우
                    if(!visited[crashed][nx][ny]) {
                        visited[crashed][nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        q.add(new int[] {nx, ny, crashed});  // 지금 값 그대로
                    }
                }

                // 도착 지점 (N-1, M-1) 도착하면 종료
                if(nx == N -1 && ny == M-1) {
                    return map[nx][ny] + 1;
                }
            }
        }

        return -1;  // 도착 지점 못 도달하면 -1
    }
}
import java.util.*;
        import java.io.*;
public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;   // 부서짐 여부 (1: 부서짐), 행, 열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if(N == 1 && M == 1) {  // 이거 빠뜨리면 97%에서 틀림
            System.out.println(1);
            return;
        }

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0,0});  // 행, 열, 부숴짐 여부 (1: 부서짐)

        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];
            int crashed = now[2];

            for(int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;

                if(map[nx][ny] == 1) {  // 벽인 경우
                    if(crashed == 0 && !visited[1][nx][ny]) {    // 부수지 않고, 방문한 적 없는 벽인 경우
                        visited[crashed][nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        q.add(new int[] {nx, ny, 1}); // 1: 벽 부숨
                    }
                }
                else {  // 빈 칸인 경우
                    if(!visited[crashed][nx][ny]) {
                        visited[crashed][nx][ny] = true;
                        map[nx][ny] = map[x][y] + 1;
                        q.add(new int[] {nx, ny, crashed});  // 지금 값 그대로
                    }
                }

                // 도착 지점 (N-1, M-1) 도착하면 종료
                if(nx == N -1 && ny == M-1) {
                    return map[nx][ny] + 1;
                }
            }
        }

        return -1;  // 도착 지점 못 도달하면 -1
    }
}
