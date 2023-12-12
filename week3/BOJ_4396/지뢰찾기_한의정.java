import java.util.*;
import java.io.*;

public class 지뢰찾기_한의정 {
    static int[] dx = {0,0,-1,1, -1, -1, 1, 1};   // 상하좌우 대각선 8방향
    static int[] dy = {1,-1,0,0, -1, 1, 1, -1};

    static int N;
    static char[][] board;      // 2차원 격자 배열
    static boolean[][] visited; // 방문 배열
    static int[][]  ans;        // 지뢰 갯수 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        ans = new int[N][N];
        visited = new boolean[N][N];

        // 1. 지뢰 위치 입력받기
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 2. 열린 / 안 열린 칸 입력받기
        boolean touchBomb = false;

        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++) {
                char ch = str.charAt(j);

                // 열린 경우
                if(ch == 'x') {
                    // 지뢰 아닌 칸이 열린 경우, 주변 지뢰 갯수 세서 배열에 저장
                    if(board[i][j] == '.') {
                        visited[i][j] = true;
                        countBombs(i, j);
                    }
                    // 지뢰인 칸이 열린 경우
                    else {
                        touchBomb = true;
                    }
                }

            }
        }

        // 3. 출력하기
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                // 지뢰 안 건드린 경우, 방문 안 한 모든 칸을 '.'으로 출력
                if(!touchBomb) {
                    if(visited[i][j]) {
                        sb.append(ans[i][j]);
                    }
                    else {
                        sb.append(".");
                    }
                }
                // 지뢰 건드린 경우, 방문 안 한 칸 中 지뢰인 칸은 '*'으로 출력
                else {
                    if(visited[i][j]) {
                        sb.append(ans[i][j]);
                    }
                    else {
                        if(board[i][j] == '*') {
                            sb.append('*');
                        }
                        else {
                            sb.append(".");
                        }
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 현재 위치 주변의 지뢰 갯수 세는 함수
    private static void countBombs(int x, int y) {
        for(int d = 0 ; d < 8 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!inRange(nx, ny))    continue;

            if(board[nx][ny] == '*') {
                ans[x][y]++;
            }
        }
    }

    // 격자 범위 내에 있는지 판별하는 함수
    private static boolean inRange(int x, int y) {
        return (0 <= x && x < N && 0 <= y && y < N);
    }
}
