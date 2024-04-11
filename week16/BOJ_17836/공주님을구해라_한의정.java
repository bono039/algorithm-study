import java.util.*;
import java.io.*;

public class 공주님을구해라_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N,M,T;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2]; // visited[x][y][1]: (x,y)에서 그람 존재함을 의미

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();
        System.out.println(result == -1 ? "Fail" : result);
    }

    private static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0, 0, 0});  // 행, 열, 검 유무, 이동 시간

        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int s = now[2];
            int t = now[3];

            if(t > T)   // 걸린 시간이 t보다 크면 while문 탈출
                break;
            if(x == N-1 && y == M-1)    // 도착 지점에 도착하면 현재까지 걸린 시간 리턴
                return t;

            for(int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >= 0 || nx < N || ny >= 0 || ny < M) {
                    if(s == 0) {    // 그람(검)이 없는 경우
                        if(!visited[nx][ny][0] && map[nx][ny] == 0) {
                            visited[nx][ny][0] = true;
                            q.add(new int[] {nx, ny, s, t + 1});
                        }
                        else if(!visited[nx][ny][0] && map[nx][ny] == 2) {  // 그람 존재 확인
                            visited[nx][ny][0] = true;
                            q.add(new int[] {nx, ny, s + 1, t + 1});    // 그람 존재 나타내기 (s+1)
                        }
                    }
                    else {  // 그람이 있는 경우
                        if(!visited[nx][ny][1]) {
                            q.add(new int[]{nx, ny, s, t + 1});
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }

        return -1;  // 도착 지점에 도착하지 못 하면 -1
    }
}
