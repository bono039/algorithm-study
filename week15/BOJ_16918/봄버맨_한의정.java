import java.util.*;
import java.io.*;

public class 봄버맨_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int R,C,N;
    static char[][] board;
    static int[][] timeArr; // 폭탄 놓인 시간 기록용 배열
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        timeArr = new int[R][C];

        for(int i = 0 ; i < R ; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0 ; j < C ; j++) {
                board[i][j] = ch[j];

                if(board[i][j] == 'O')
                    timeArr[i][j] = 3;  // 폭탄 터질 시간 (놓인 시간 +3)
            }
        }

        time = 1;   // 1초부터 시작 !! (1초에는 아무 것도 안 함)
        while(time <= N) {
            if(time % 2 == 0) { // 짝수 초 : 비어있는 모든 칸에 폭탄 설치
                installBombs();
            }
            else if(time % 2 == 1) { // 홀수 초 : 폭탄 터지기
                boom();
            }

            time++;
        }

        printArray();   // 결과 출력하기
    }

    // 비어있는 모든 칸에 폭탄 설치하는 메소드
    private static void installBombs() {
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(board[i][j] == '.') {    // 비어있는 모든 칸에 폭탄 설치
                    board[i][j] = 'O';
                    timeArr[i][j] = time +3;    // 폭탄 터질 시간 저장
                }
            }
        }
    }

    // 폭탄 터지는 메소드
    private static void boom() {
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                if(timeArr[i][j] == time) { // 시간이 다 된 폭탄 터트리기
                    board[i][j] = '.';

                    for(int d = 0 ; d < 4 ; d++) {  // 인접한 4방향 터트리기
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if(nx < 0 || nx >= R || ny < 0 || ny >= C)  continue;
                        if(board[nx][ny] == 'O') {
                            if(timeArr[nx][ny] != time) {   // 현재 시간에 터지지 않는 폭탄만 폭발시키기!
                                board[nx][ny] = '.';
                                timeArr[nx][ny] = 0;
                            }
                        }
                    }
                }
            }
        }
    }

    // 출력 메소드
    private static void printArray() {
        StringBuilder sb = new StringBuilder();
        for(char[] ch : board) {
            for(char c : ch) {
                sb.append(c);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
