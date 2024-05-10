import java.util.*;
import java.io.*;

public class 쉬운최단거리_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N,M;
    static int[][] map, dist;
    static boolean[][] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 세로 = 행
        M = Integer.parseInt(st.nextToken());   // 가로 = 열

        map = new int[N][M];
        dist = new int[N][M];
        chk = new boolean[N][M];

        int x = 0, y = 0;   // 2가 있는 목표 지점 !!

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {    // 목표 지점 위치 저장하기
                    x = i;
                    y = j;
                }
                else if(map[i][j] == 0) {   // 0은 미리 방문 처리
                    chk[i][j] = true;
                }
            }
        }

        // 목표 지점 2 기준 거리 재기
        bfs(x, y);
        printArray();
    }

    // 목표 지점 2 기준 거리 재기
    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y,});

        chk[x][y] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(0 > nx || nx >= N || 0 > ny || ny >= M)  continue;

                if(!chk[nx][ny] && map[nx][ny] == 1) {  // 방문한 적 없는 갈 수 있는 땅으로 이동
                    chk[nx][ny] = true;
                    dist[nx][ny] = dist[now[0]][now[1]] + 1; // 현재 길이 = 이전 길이 +1
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void printArray() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(!chk[i][j]) {
                    dist[i][j] = -1;
                }
                sb.append(dist[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
