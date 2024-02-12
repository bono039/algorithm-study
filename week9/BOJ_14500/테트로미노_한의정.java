import java.util.*;
import java.io.*;

public class 테트로미노_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N, M;
    static int[][] grid;
    static boolean[][] visited; // (i, j) 위치 값 중복해 뽑지 않기 위한 배열

    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 위치 (i, j)부터 원소 4개 선택하기
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, grid[i][j]);
                visited[i][j] = false;

                check(i, j);    // ㅜ자 모양은 특수처리
            }
        }

        System.out.println(max);
    }

    private static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(inRange(nx,ny) && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth +1, sum + grid[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }

    private static void check(int x, int y) {
        if(x + 1 < N && y + 2 < M)  // ㅜ
            max = Math.max(max, grid[x][y] + grid[x][y+1] + grid[x][y+2] + grid[x+1][y+1]);

        if(x + 2 < N && y + 1 < M)  // ㅓ
            max = Math.max(max, grid[x][y + 1] + grid[x+1][y] + grid[x+1][y+1] + grid[x+2][y+1]);

        if(x + 2 < N && y + 1 < M)  // ㅏ
            max = Math.max(max, grid[x][y] + grid[x+1][y] + grid[x+2][y] + grid[x+1][y+1]);

        if(x + 1 < N && y + 2 < M)    // ㅗ
            max = Math.max(max, grid[x][y+1] + grid[x+1][y] + grid[x+1][y+1] + grid[x+1][y+2]);
    }

    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < M);
    }
}
