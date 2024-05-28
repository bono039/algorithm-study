import java.util.*;
import java.io.*;

public class 십자가2개놓기_한의정 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    static int N,M;
    static char[][] board;
    static boolean[][] visited;
    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];

        // 격자판 정보 저장하기
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 첫 번째 십자가 놓기
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(board[i][j] == '#') {
                    visited = new boolean[N][M];

                    int tmp = Math.max(i, j);   // 놓을 수 있는 최대 십자가 크기

                    for(int x = 0 ; x <= tmp ; x++) {
                        // 해당 크기의 십자가가 격자판에 놓일 수 있는지 확인
                        if(!crossChk(i,j,x))
                            break;

                        // 놓을 수 있을 때, 2번째 십자가 탐색
                        search(i,j,x);
                    }
                }
            }
        }

        System.out.println(max);
    }

    // 해당 크기 십자가가 격자판에 놓일 수 있는지 확인하는 함수
    private static boolean crossChk(int y, int x, int size) {
        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d] * size;
            int ny = y + dy[d] * size;

            if(!inRange(nx, ny) || board[ny][nx] != '#')
                return false;
        }

        // 십자가 두기
        visited[y+size][x] = true;
        visited[y-size][x] = true;
        visited[y][x+size] = true;
        visited[y][x-size] = true;
        return true;
    }

    // 2번째 십자가의 최대 크기 탐색하는 함수
    private static void search(int y, int x, int size) {
        int result = 0;

        for(int i = x+1 ; i < M ; i++) {
            if(board[y][i] == '#') {
                result = Math.max(result, getCrossMaxSize(y, i));
            }
        }

        for(int i = y+1 ; i < N ; i++) {
            for(int j = 0 ; j < M ; j++) {
                if(board[i][j] == '#') {
                    result = Math.max(result, getCrossMaxSize(i, j));
                }
            }
        }

        max = Math.max(max, crossSize(size) * crossSize(result));
    }

    // 해당 좌표에서 놓을 수 있는 최대 십자가 크기 구하는 함수
    private static int getCrossMaxSize(int y, int x) {
        int result = 1;

        while(true) {
            boolean chk = false;

            for(int d = 0 ; d < 4 ; d++) {
                int nx = x + dx[d] * result;
                int ny = y + dy[d] * result;

                if(!inRange(nx, ny) || board[ny][nx] != '#' || visited[ny][nx]) {
                    chk = true;
                    break;
                }
            }

            if(chk) {
                break;
            }
            result++;
        }

        return result - 1;
    }

    // 십자가 크기에 따른 넓이 구하는 함수
    private static int crossSize(int size) {
        return size*4 + 1;
    }

    private static boolean inRange(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }
}
