import java.util.*;
import java.io.*;

public class 단지번호붙이기_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();   // 단지 내 집 수 저장용 우선순위 큐 (자동 오름차순 정렬)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {  // 방문하지 않은 집에 대해 단지 탐색
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // 1. 총 단지수 출력
        sb.append(pq.size()).append("\n");

        // 2. 각 단지내 집 수 오름차순으로 하나씩 출력
        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 단지 탐색 메소드
    private static void bfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;    // 단지수

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {  // 연결된 집
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N)  continue;

                if(!visited[nx][ny] && map[nx][ny] == 1) {  // 방문하지 않은 집 마저 탐색
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                    cnt++;  // 단지수 +1
                }
            }
        }

        pq.add(cnt);    // 해당 단지의 단지수 저장
    }
}
