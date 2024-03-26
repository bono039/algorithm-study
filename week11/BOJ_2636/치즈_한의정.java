import java.util.*;
import java.io.*;

public class 치즈_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, M;
    static int[][] map;

    static int time = 0;    // 치즈가 모두 녹아 없어지는 데 걸리는 시간
    static List<Integer> list = new ArrayList<>();  // 남은 치즈 조각 수 저장 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            if(!cheeseExists()) break;  // 치즈가 존재하지 않는다면 반복문 종료

            time++; // 걸린 시간 +1
            melt(); // 치즈 녹이기
        }

        System.out.println(time);
        System.out.println(list.get(list.size() - 1));
    }

    private static boolean cheeseExists() {
        boolean exists = false;
        int cnt = 0;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(map[i][j] == 1) {
                    exists = true;
                    cnt++;
                }
            }
        }

        if(cnt != 0)    list.add(cnt);

        return exists;
    }

    // BFS로 치즈 녹이기
    private static void melt() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0, 0});

        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {  // 4방향 탐색
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                // 격자 범위 내에 없거나 방문한 적 있는 칸이면 pass
                if(!inRange(nx, ny) || visited[nx][ny])    continue;

                if(map[nx][ny] == 0) {  // 방문한 적 없는 치즈가 놓여있지 않은 칸은 큐에 추가해 마저 탐색
                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
                else if(map[nx][ny] == 1) { // 방문한 적 없는 치즈가 놓여있는 칸은 치즈 녹이기
                    visited[nx][ny] = true;
                    map[nx][ny] = 0;
                }
            }
        }
    }

    // 격자 범위 벗어나는지 확인하는 메서드
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
