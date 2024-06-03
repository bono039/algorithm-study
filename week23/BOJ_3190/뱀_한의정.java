import java.util.*;
import java.io.*;

public class 뱀_한의정 {
    static int[] dx = {0, 1, 0, -1};   // 동남서북
    static int[] dy = {1, 0, -1, 0};

    static int N,K,L;
    static int[][] board;
    static List<int[]> snake = new ArrayList<>();   // 뱀
    static Map<Integer, Character> map = new HashMap<>();   // 뱀 방향 변환 정보 저장용 맵 (시간, 방향)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        // 사과 위치 정보
        board = new int[N][N];
        while(K-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            board[r][c] = 1;  // 사과
        }

        // 방향 변환 정보
        L = Integer.parseInt(br.readLine());
        while(L --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            map.put(x, c);
        }

        solve();
    }

    private static void solve() {
        // 뱀 머리 시작점
        int x = 0;
        int y = 0;

        int time = 0;
        int d = 0;
        snake.add(new int[] {0,0});

        while(true) {
            // 1. 시간 +1
            time++;

            // 2. 뱀 이동하기
            int nx = x + dx[d];
            int ny = y + dy[d];

            // 3. 범위 벗어나거나, 뱀 몸통 만나면 종료
            if(!canGo(nx, ny))  break;

            // 4. 사과 있는지 확인하기
            if(board[nx][ny] == 1) {
                board[nx][ny] = 0;
                snake.add(new int[]{nx, ny});
            }
            else {
                snake.add(new int[]{nx, ny});
                snake.remove(0);    // snake 꼬리 제거
            }

            // 5. 방향 바꾸는 시간일 때, 방향 변경
            if(map.containsKey(time)) {
                if(map.get(time) == 'D') {  // 오른쪽으로 90도 회전
                    d = (d + 1) % 4;
                }
                else {  // 왼쪽으로 90도 회전
                    d = (d - 1 + 4) % 4;
                }
            }

            // 6. 현재 이동 좌표 업데이트
            x = nx;
            y = ny;
        }

        System.out.println(time);
    }

    private static boolean canGo(int x, int y) {
        // 격자 범위 벗어나면 이동 불가
        if(x < 0 || x >= N || y < 0 || y >= N)
            return false;

        for(int i = 0 ; i < snake.size() ; i++) {
            int[] tmp = snake.get(i);

            // 뱀 몸통이 있는 위치로 이동하려고 하면 이동 불가
            if(x == tmp[0] && y == tmp[1])
                return false;
        }

        return true;
    }
}
