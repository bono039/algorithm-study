import java.util.*;
import java.io.*;

public class 뒤집기2_한의정 {
    static int N,M;
    static int[][] board;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for(int i = 0 ; i < N ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        // 오른쪽 아래부터 역순으로 오면서 뒤집기
        for(int i = M-1 ; i >= 0 ; i--) {
            for(int j = N-1 ; j >= 0 ; j--) {
                // 1 만나면 axb만큼 뒤집기
                if(board[j][i] == 1) {
                    flip(j, i);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void flip(int a, int b) {
        for(int i = 0 ; i <= a ; i++) {
            for(int j = 0 ; j <= b ; j++) {
                if(board[i][j] == 1) board[i][j] = 0;
                else                 board[i][j] = 1;
            }
        }
    }
}
