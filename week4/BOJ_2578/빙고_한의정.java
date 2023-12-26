import java.util.*;
import java.io.*;

public class 빙고_한의정 {
    static int[][] board;
    static int bingo = 0;
    static int turn = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[5][5];
        for(int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 5 ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < 5 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 5 ; j++) {
                int findNum = Integer.parseInt(st.nextToken());

                // 불린 숫자 찾기 (찾으면 0으로 표시)
                for(int a = 0 ; a < 5 ; a++) {
                    for(int b = 0 ; b < 5 ; b++) {
                        if(board[a][b] == findNum) {
                            board[a][b] = 0;
                        }
                    }
                }

                rCheck();   // 행에서 빙고 확인
                cCheck();   // 열에서 빙고 확인
                lrCheck();  // 대각선1에서 빙고 확인
                rlCheck();  // 대각선2에서 빙고 확인

                // 빙고 갯수가 3개 이상이면, 턴 출력하고 종료
                if(bingo >= 3) {
                    System.out.println(turn);
                    return;
                }

                // 빙고 갯수가 3개 미만이면, 빙고 갯수 초기화하고 턴 수 + 1
                bingo = 0;
                turn++;
            }
        }
    }

    private static void rCheck() {
        for(int i = 0 ; i < 5 ; i++) {
            int zeroCnt = 0;
            for(int j = 0 ; j < 5 ; j++) {
                if(board[i][j] == 0)
                    zeroCnt++;
            }

            // 해당 행에서 0의 갯수가 5개면, 빙고
            if(zeroCnt == 5)
                bingo++;
        }
    }

    private static void cCheck() {
        for(int i = 0 ; i < 5 ; i++) {
            int zeroCnt = 0;
            for(int j = 0 ; j < 5 ; j++) {
                if(board[j][i] == 0)
                    zeroCnt++;
            }

            // 해당 열에서 0의 갯수가 5개면, 빙고
            if(zeroCnt == 5)
                bingo++;
        }
    }

    private static void lrCheck() {
        int zeroCnt = 0;
        for(int i = 0 ; i < 5 ; i++) {
            if(board[i][i] == 0)
                zeroCnt++;
        }

        // 해당 대각선에서 0의 갯수가 5개면, 빙고
        if(zeroCnt == 5) {
            bingo++;
        }
    }

    private static void rlCheck() {
        int zeroCnt = 0;
        for(int i = 0 ; i < 5 ; i++) {
            if(board[i][4 - i] == 0)
                zeroCnt++;
        }
        if(zeroCnt == 5) {
            bingo++;
        }
    }
}
