import java.util.*;
import java.io.*;

public class 마법사상어와비바라기_한의정 {
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};   // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int N,M;
    static int[][] A;   // 저장된 물의 양
    static boolean[][] visited;	// 구름이었던 적 있었는지 나타내는 방문 표시 배열
    static Queue<int[]> clouds = new ArrayDeque<>();	// 구름 위치 저장용 큐

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 비구름 위치 저장
        clouds.add(new int[] {N-1, 0});
        clouds.add(new int[] {N-1, 1});
        clouds.add(new int[] {N-2, 0});
        clouds.add(new int[] {N-2, 1});

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            visited = new boolean[N][N];
            step12(d-1, s);
            step34();
            step5();
        }

        System.out.println(printSum());
    }

    private static void step12(int d, int s) {
        for(int[] c : clouds) {
            // 1. 구름 d방향으로 s칸 이동시키기
            c[0] = (N + c[0] + dx[d] * (s % N)) % N;
            c[1] = (N + c[1] + dy[d] * (s % N)) % N;
            visited[c[0]][c[1]] = true;  // 구름인 적 있었다고 표시

            // 2. 비 내리기
            A[c[0]][c[1]]++;
        }
    }

    private static void step34() {
        while(!clouds.isEmpty()) {
            int[] now = clouds.poll();  // 3. 구름 없애기
            addWater(now[0], now[1]);   // 4. 물복사버그 마법
        }
    }

    // 대각선 물 갯수 세는 메서드
    private static void addWater(int x, int y) {
        for(int i = 1 ; i <= 7 ; i += 2) {  // 1, 3, 5, 7
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && A[nx][ny] > 0)
                A[x][y]++;
        }
    }

    private static void step5() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(A[i][j] >= 2 && !visited[i][j]) {
                    clouds.add(new int[] {i, j});
                    A[i][j] -= 2;
                }
            }
        }
    }

    private static int printSum() {
        int sum = 0;

        for(int[] i : A) {
            for(int j : i)
                sum += j;
        }

        return sum;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
