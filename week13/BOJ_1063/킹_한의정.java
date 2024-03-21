import java.util.*;
import java.io.*;

public class 킹_한의정 {
    static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};   // R, L, B, T, RT, LT, RB,LB
    static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

    static int[][] board = new int[8][8];   // 1: 돌
    static int[] king, stone;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        king = new int[] {str[0].charAt(0) -'A', Integer.parseInt(str[0].substring(1)) -1};
        stone = new int[] {str[1].charAt(0) -'A', Integer.parseInt(str[1].substring(1)) -1};
        cnt = Integer.parseInt(str[2]);

        board[stone[0]][stone[1]] = 1;  // 돌 두기

        while(cnt --> 0) {
            move(br.readLine());
        }

        System.out.println((char)(king[0] + 'A') + "" + (king[1] +1));
        System.out.println((char)(stone[0] + 'A') + "" + (stone[1] +1));
    }

    private static void move(String cmd) {
        int dir = 0;

        switch(cmd) {
            case "R":
                dir = 0;
                break;
            case "L":
                dir = 1;
                break;
            case "B":
                dir = 2;
                break;
            case "T":
                dir = 3;
                break;
            case "RT":
                dir = 4;
                break;
            case "LT":
                dir = 5;
                break;
            case "RB":
                dir = 6;
                break;
            case "LB":
                dir = 7;
                break;
        }

        // 킹이 이동할 위치
        int nx = king[0] + dx[dir];
        int ny = king[1] + dy[dir];

        if(!inRange(nx, ny))    return; // 킹이 이동할 위치가 격자 범위 벗어나면 리턴

        if(board[nx][ny] != 0) {    // 이동한 곳에 돌이 있는 경우
            int sx = stone[0] + dx[dir];
            int sy = stone[1] + dy[dir];

            if(!inRange(sx, sy))    return; // 돌이 더 이상 이동할 수 없으면, 킹도 이동 못 시키고 리턴 !!

            // 돌도 이동 가능하면, 킹과 같은 방향으로 한 칸 이동
            board[stone[0]][stone[1]] = 0;
            stone[0] = sx;
            stone[1] = sy;
            board[stone[0]][stone[1]] = 1;
        }

        // 킹 이동하기
        king[0] = nx;
        king[1] = ny;
    }

    // 범위 벗어나는지 확인
    private static boolean inRange(int x, int y) {
        return 0 <= x && x < 8 && 0 <= y && y < 8;
    }
}
