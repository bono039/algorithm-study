import java.util.*;
import java.io.*;

public class 오목_한의정 {
    static int[][] board;

    static List<int[]> bList = new ArrayList<>();   // 검은 돌 좌표 리스트
    static List<int[]> wList = new ArrayList<>();   // 흰 돌 좌표 리스트

    static int blackScore, whiteScore;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int[20][20];
        for(int i = 1 ; i <= 19 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= 19 ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i <= 19 ; i++) {
            for(int j = 1 ; j <= 19 ; j++) {
                if(board[i][j] == 0)    continue;

                rCheck(i, j);   // 가로 확인
                cCheck(i, j);   // 세로 확인
                lrCheck(i, j);  // 대각선1 확인
                rlCheck(i, j);  // 대각선2 확인
            }
        }

        // 검은 돌과 흰 돌 좌표 리스트, 가장 왼쪽 위에 있는 값 나오도록 정렬
        Collections.sort(bList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        Collections.sort(wList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        if(blackScore > whiteScore) {
            System.out.println(1);
            System.out.println(bList.get(0)[0] + " " + bList.get(0)[1]);
        }
        else if(blackScore < whiteScore) {
            System.out.println(2);
            System.out.println(wList.get(0)[0] + " " + wList.get(0)[1]);
        }
        else {
            System.out.println(0);
        }
    }

    private static void rCheck(int i, int j) {
        if(board[i][j] == 0 || !inRange(i, j + 4))    return;

        if((board[i][j] == board[i][j + 1]) && (board[i][j + 1] == board[i][j + 2]) && (board[i][j + 2] == board[i][j + 3]) && (board[i][j + 3] == board[i][j + 4])) {
            // 오목 갯수가 6개 이상이 되면, 패스
            if(inRange(i, j - 1) && board[i][j] == board[i][j - 1]) return;
            if(inRange(i, j + 5) && board[i][j] == board[i][j + 5]) return;

            if(board[i][j] == 1) {
                bList.add(new int[] {i, j});
                blackScore++;
            }
            else if(board[i][j] == 2) {
                wList.add(new int[] {i, j});
                whiteScore++;
            }
        }
    }

    private static void cCheck(int i, int j) {
        if(board[i][j] == 0 || !inRange(i + 4, j))    return;

        if((board[i][j] == board[i + 1][j]) && (board[i + 1][j] == board[i + 2][j]) && (board[i + 2][j] == board[i + 3][j]) && (board[i + 3][j] == board[i + 4][j])) {
            // 오목 갯수가 6개 이상이 되면, 패스
            if(inRange(i - 1, j) && board[i][j] == board[i - 1][j]) return;
            if(inRange(i + 5, j) && board[i][j] == board[i + 5][j]) return;

            if(board[i][j] == 1) {
                bList.add(new int[] {i, j});
                blackScore++;
            }
            else if(board[i][j] == 2) {
                wList.add(new int[] {i, j});
                whiteScore++;
            }
        }
    }

    private static void lrCheck(int i, int j) {
        if(board[i][j] == 0 || !inRange(i + 4, j + 4))    return;

        if((board[i][j] == board[i + 1][j + 1]) && (board[i + 1][j + 1] == board[i + 2][j + 2]) && (board[i + 2][j + 2] == board[i + 3][j + 3]) && (board[i + 3][j + 3] == board[i + 4][j + 4])) {
            // 오목 갯수가 6개 이상이 되면, 패스
            if(inRange(i - 1, j - 1) && board[i][j] == board[i - 1][j - 1]) return;
            if(inRange(i + 5, j + 5) && board[i][j] == board[i + 5][j + 5]) return;

            if(board[i][j] == 1) {
                bList.add(new int[] {i, j});
                blackScore++;
            }
            else if(board[i][j] == 2) {
                wList.add(new int[] {i, j});
                whiteScore++;
            }
        }
    }

    private static void rlCheck(int i, int j) {
        if(board[i][j] == 0 || !inRange(i + 4, j - 4))    return;

        if((board[i][j] == board[i + 1][j - 1]) && (board[i + 1][j - 1] == board[i + 2][j - 2]) && (board[i + 2][j - 2] == board[i + 3][j - 3]) && (board[i + 3][j - 3] == board[i + 4][j - 4])) {
            // 오목 갯수가 6개 이상이 되면, 패스
            if(inRange(i - 1, j + 1) && board[i][j] == board[i - 1][j + 1]) return;
            if(inRange(i + 5, j - 5) && board[i][j] == board[i + 5][j - 5]) return;

            if(board[i][j] == 1) {
                bList.add(new int[] {i + 4, j - 4});
                blackScore++;
            }
            else if(board[i][j] == 2) {
                wList.add(new int[] {i + 4, j - 4});
                whiteScore++;
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return (1 <= r && r <= 19 && 1 <= c && c <= 19);
    }
}
