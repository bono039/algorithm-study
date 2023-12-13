import java.util.*;
import java.io.*;

public class 달팽이_한의정 {
    static int[] dx = {1, 0, -1, 0};   // 회전 순서 : 아래쪽 (0) → 오른쪽 (1) → 위쪽 (2) → 왼쪽 (3)
    static int[] dy = {0, 1, 0, -1};

    static int N, findNum;
    static int[][] map;

    static int[] pos = {0, 0};      // 현재 좌표 위치
    static int[] ans = new int[2];  // 찾는 번호 좌표
    static int dir = 0;             // 방향 : 아래쪽(0)부터 시작

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        findNum = Integer.parseInt(br.readLine());

        map = new int[N][N];

        // 달팽이 채우기
        fillSnail();

        // 출력하기
        printSnail();
        sb.append(ans[0] + " " + ans[1]);

        System.out.println(sb);
    }

    // 회전하면서 달팽이 채우는 메소드
    private static void fillSnail() {
        map[0][0] = N * N;  // 초기값

        for(int i = N * N - 1 ; i >= 1 ; i--) {
            int nx = pos[0] + dx[dir];
            int ny = pos[1] + dy[dir];

            // 격자 벗어나거나 방문한 칸인 경우, 방향 전환
            if(!inRange(nx, ny) || (map[nx][ny] != 0)) {
                dir = (dir + 1) % 4;
            }

            // 다음 위치로 이동하고, 칸에 올바른 값 채워넣기
            pos[0] += dx[dir];
            pos[1] += dy[dir];

            map[pos[0]][pos[1]] = i;
        }
    }

    // 격자 벗어나는지 판별용 메소드
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }

    // 달팽이 출력 메소드
    private static void printSnail() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                sb.append(map[i][j] + " ");

                // 찾는 번호면, 해당 위치 값 저장
                if(map[i][j] == findNum) {
                    ans = new int[]{i + 1, j + 1};
                }
            }
            sb.append("\n");
        }

        return;
    }
}
