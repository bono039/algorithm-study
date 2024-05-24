import java.util.*;
import java.io.*;

public class 파이프옮기기1_한의정 {
    static int N;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,1,0);
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int dir) {
        if(x == N-1 && y == N-1) {  // [종료 조건] 목적지 도착 시
            answer++;
            return;
        }

        // 1. 가로 방향인 경우, → ↘  이동 가능
        if(dir == 0) {
            if(inRange(x, y+1) && map[x][y+1] == 0)  // → 이동
                dfs(x, y+1, 0);
        }
        // 2. 세로 방향인 경우, ↓ ↘ 이동 가능
        else if(dir == 1) {
            if(inRange(x+1, y) && map[x+1][y] == 0) // ↓ 이동
                dfs(x+1, y, 1);
        }
        // 3. 대각선 방향인 경우, → ↓ ↘ 이동 가능
        else if(dir == 2) {
            if(inRange(x, y+1) && map[x][y+1] == 0) // → 이동
                dfs(x, y+1, 0);

            if(inRange(x+1, y) && map[x+1][y] == 0) // ↓ 이동
                dfs(x+1, y, 1);
        }

        // [공통] 어떤 방향이든,  ↘  이동
        if(inRange(x+1, y+1) && map[x][y+1] == 0 && map[x+1][y] == 0 && map[x+1][y+1] == 0)
            dfs(x+1, y+1, 2);
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}
