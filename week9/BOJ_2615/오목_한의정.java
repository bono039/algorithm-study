import java.util.*;
import java.io.*;

public class 오목_한의정 {
    static int[][] board = new int[20][20];

    static List<int[]> blackList = new ArrayList<>();
    static List<int[]> whiteList = new ArrayList<>();

    static int blackScore, whiteScore, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 1 ; i <= 19 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= 19 ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 1)         blackList.add(new int[]{i, j});
                else if(board[i][j] == 2)    whiteList.add(new int[] {i, j});
            }
        }

        // 검은 돌 오목 확인
        for(int i = 0 ; i < blackList.size() ; i++) {
            int[] now = blackList.get(i);

            if(chkGaro(now[0], now[1], 1) == 5) {
                R = now[0];
                C = now[1];
                blackScore++;
            }
            if(chkSero(now[0], now[1], 1) == 5) {
                R = now[0];
                C = now[1];
                blackScore++;
            }
            if(chkLine1(now[0], now[1], 1) == 5) {  // \
                R = now[0];
                C = now[1];
                blackScore++;
            }
            if(chkLine2(now[0], now[1], 1) == 5) {  // /
                R = now[0] + 4;
                C = now[1] - 4;
                blackScore++;
            }
        }

        // 흰 돌 오목 확인
        for(int i = 0 ; i < whiteList.size() ; i++) {
            int[] now = whiteList.get(i);

            if(chkGaro(now[0], now[1], 2) == 5) {
                R = now[0];
                C = now[1];
                whiteScore++;
            }
            if(chkSero(now[0], now[1], 2) == 5) {
                R = now[0];
                C = now[1];
                whiteScore++;
            }
            if(chkLine1(now[0], now[1], 2) == 5) {  // \
                R = now[0];
                C = now[1];
                whiteScore++;
            }
            if(chkLine2(now[0], now[1], 2) == 5) {  // /
                R = now[0] + 4;
                C = now[1] - 4;
                whiteScore++;
            }
        }

        // 출력하기
        if(blackScore == whiteScore) {
            System.out.println(0);
        }
        else {
            System.out.println(blackScore > whiteScore ? 1 : 2);
            System.out.println(R + " " + C);
        }
    }

    // 가로 확인 메서드
    private static int chkGaro(int x, int y, int targetNum) {
        int cnt = 0;

        for(int i = y ; i < y + 5 ; i++) {
            if(!inRange(x, i))  return 0;
            if(board[x][i] == targetNum) {
                cnt++;
            }
        }

        if(inRange(x, y - 1) && board[x][y - 1] == targetNum)   return 0;
        if(inRange(x, y + 5) && board[x][y + 5] == targetNum)   return 0;

        return cnt;
    }

    // 세로 확인 메서드
    private static int chkSero(int x, int y, int targetNum) {
        int cnt = 0;

        for(int i = x ; i < x + 5 ; i++) {
            if(!inRange(i, y))  return 0;
            if(board[i][y] == targetNum) {
                cnt++;
            }
        }

        if(inRange(x - 1, y) && board[x - 1][y] == targetNum)   return 0;
        if(inRange(x + 5, y) && board[x + 5][y] == targetNum)   return 0;

        return cnt;
    }

    // 대각선1 \ 확인 메서드
    private static int chkLine1(int x, int y, int targetNum) {
        int cnt = 0;

        for(int i = 0 ; i < 5 ; i++) {
            if(!inRange(x + i, y + i))  return 0;
            if(board[x + i][y + i] == targetNum)
                cnt++;
        }

        if(inRange(x - 1, y - 1) && board[x - 1][y - 1] == targetNum)   return 0;
        if(inRange(x + 5, y + 5) && board[x + 5][y + 5] == targetNum)   return 0;

        return cnt;
    }


    // 대각선2 / 확인 메서드
    private static int chkLine2(int x, int y, int targetNum) {
        int cnt = 0;

        for(int i = 0 ; i < 5 ; i++) {
            if(!inRange(x + i, y - i))  return 0;
            if(board[x + i][y - i] == targetNum)
                cnt++;
        }

        if(inRange(x - 1, y + 1) && board[x - 1][y + 1] == targetNum)   return 0;
        if(inRange(x + 5, y - 5) && board[x + 5][y - 5] == targetNum)   return 0;

        return cnt;
    }

    private static boolean inRange(int x, int y) {
        return (1 <= x && x <= 19 && 1 <= y && y <= 19);
    }
}
