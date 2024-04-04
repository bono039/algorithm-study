import java.util.*;
import java.io.*;
// 60m O
public class 인구이동_한의정 {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int N,L,R;
    static int[][] map;
    static boolean[][] visited;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());   // 인구 차이 최소
        R = Integer.parseInt(st.nextToken());   // 인구 차이 최대

        map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];
        while(move()) {   // 인구 이동이 없을 때까지 인구 이동
            cnt++;
            visited = new boolean[N][N];    // = 연합 해체
        }

        System.out.println(cnt);
    }

    // 인구 이동 가능한지 판별하는 메서드 (이동 가능하면 이동시킴)
    private static boolean move() {
        boolean ok = false; // 이동 가능 여부

        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;   // 방문 처리
                    boolean opened = false; // 국경선 열렸는지 여부

                    for(int d = 0 ; d < 4 ; d++) {  // 4방향 탐색
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        // 격자 범위 내에 있고, 두 나라 간 인구 차이가 L과 R사이라면
                        if(inRange(nr, nc) && betweenLR(i, j, nr, nc)) {
                            opened = true;  // 국경선 열림
                            ok = true;      // 이동 가능
                        }
                    }

                    if(opened) {    // 국경선이 열렸다면, 이동하며 연합
                        bfs(i, j);
                    }
                }
            }
        }

        return ok;
    }

    // 인접한 국경선이 열린 나라끼리 이동하며 연합하는 메서드
    private static void bfs(int x, int y) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        List<int[]> list = new ArrayList<>();   // 연합한 나라의 x,y 좌표 & 인구 수 저장 리스트
        list.add(new int[] {x, y, map[x][y]});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dr[d];
                int ny = now[1] + dc[d];

                // 방문한 적 없고, 이동 가능한 칸이라면 이동
                if(inRange(nx, ny) && !visited[nx][ny] && betweenLR(now[0], now[1], nx, ny)) {
                    visited[nx][ny] = true;
                    list.add(new int[] {nx, ny, map[nx][ny]});
                    q.add(new int[]{nx, ny});
                }
            }
        }

        if(list.size() == 1) return;

        // 연합 국가가 2개 이상인 경우, 연합 이루는 각 칸의 인구 수 갱신
        int total = 0;
        for(int[] arr : list) {
            total += arr[2];
        }
        total /= list.size();

        for(int[] arr : list) {
            map[arr[0]][arr[1]] = total;
        }
    }

    // 두 나라 간 인구 차이가 L이상 R이하인지 확인하는 메서드
    private static boolean betweenLR(int a, int b, int c, int d) {
        int diff = Math.abs(map[a][b] - map[c][d]);
        return L <= diff && diff <= R;
    }

    private static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}
