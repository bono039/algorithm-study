import java.util.*;
import java.io.*;

public class 연구소_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N,M;
    static int[][] map, tmp;

    static List<int[]> emptyList = new ArrayList<>();   // 빈 칸 목록
    static boolean[] dfsVisited;    // 빈 칸 뽑기용

    static List<int[]> virusList = new ArrayList<>();   // 바이러스 리스트

    static int answer = 0;

    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] visited;

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

                if(map[i][j] == 0)
                    emptyList.add(new int[]{i, j});
                else if(map[i][j] == 2)
                    virusList.add(new int[]{i, j});
            }
        }

        dfsVisited = new boolean[emptyList.size()];
        dfs(0, 0);
        System.out.println(answer);
    }

    // 벽 3개 세우고, 바이러스 퍼뜨리기
    private static void dfs(int idx, int cnt) {
        if(cnt == 3) {  // 벽 3개 세웠을 때
            setWalls();
            virus();
            getSafeZone();
            return;
        }

        for(int i = idx ; i < emptyList.size() ; i++) {
            if(!dfsVisited[i]) {
                dfsVisited[i] = true;
                dfs(i + 1, cnt + 1);
                dfsVisited[i] = false;
            }
        }
    }

    // 벽 세우기
    private static void setWalls() {
        // 원본 배열 복사
        tmp = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++)
                tmp[i][j] = map[i][j];
        }

        // 선택된 벽 (disVisited == true)에 대해 벽 세우기
        for(int i = 0 ; i < dfsVisited.length ; i++) {
            if(dfsVisited[i]) {
                tmp[emptyList.get(i)[0]][emptyList.get(i)[1]] = 1;
            }
        }
    }

    // 바이러스 퍼뜨리기
    private static void virus() {
        visited = new boolean[N][M];

        for(int[] now : virusList) {
            if(!visited[now[0]][now[1]]) {  // 방문한 적 없는 바이러스를 퍼뜨릴 대상에 추가
                visited[now[0]][now[1]] = true;
                q.add(new int[]{now[0], now[1]});
            }
        }

        bfs();  // 퍼뜨리기
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {  // 인접한 4방향 퍼뜨리기
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)  continue;

                if(!visited[nx][ny] && tmp[nx][ny] == 0) {  // 방문한 적 없는 빈 칸에 퍼뜨리기
                    visited[nx][ny] = true;
                    tmp[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    // 안전영역 수 구하기
    private static void getSafeZone() {
        int cnt = 0;

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(tmp[i][j] == 0)
                    cnt++;
            }
        }

        answer = Math.max(answer, cnt); // 최대 안전영역 수 갱신
    }
}