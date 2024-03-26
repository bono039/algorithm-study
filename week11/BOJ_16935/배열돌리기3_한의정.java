import java.util.*;
import java.io.*;

public class 배열돌리기3_한의정 {
    static int N,M,R;
    static int[][] map, tmp;
    static int r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < R ; i++) {
            int num = Integer.parseInt(st.nextToken());

            r = map.length;
            c = map[0].length;

            if(num == 1)        move1();
            else if(num == 2)   move2();
            else if(num == 3)   move3();
            else if(num == 4)   move4();
            else if(num == 5)   move5();
            else if(num == 6)   move6();
        }

        print();
    }

    // 1. 상하 반전
    private static void move1() {
        tmp = new int[r][c];
        for(int i = 0 ; i < r ; i++)
            for(int j = 0 ; j < c ; j++)
                tmp[r - 1 - i][j] = map[i][j];

        map = tmp.clone();
    }

    // 2. 좌우 반전
    private static void move2() {
        tmp = new int[r][c];
        for(int i = 0 ; i < r ; i++)
            for(int j = 0 ; j < c ; j++)
                tmp[i][c - 1 - j] = map[i][j];

        map = tmp.clone();
    }

    // 3. 오른쪽으로 90도 회전
    private static void move3() {
        tmp = new int[c][r];
        for(int i = 0 ; i < r ; i++)
            for(int j = 0 ; j < c ; j++)
                tmp[j][r - 1 - i] = map[i][j];

        map = tmp.clone();
    }

    // 4. 왼쪽으로 90도 회전
    private static void move4() {
        tmp = new int[c][r];
        for(int i = 0 ; i < r ; i++)
            for(int j = 0 ; j < c ; j++)
                tmp[c - 1 - j][i] = map[i][j];

        map = tmp.clone();
    }

    // 5. 시계 방향 회전
    private static void move5() {
        tmp = new int[r][c];

        // 1 -> 2
        for(int i = 0 ; i < r/2 ; i++) {
            for(int j = 0 ; j < c/2 ; j++)
                tmp[i][j + c/2] = map[i][j];
        }

        // 2 -> 3
        for(int i = 0 ; i < r/2 ; i++) {
            for(int j = c/2 ; j < c ; j++)
                tmp[i + r/2][j] = map[i][j];
        }

        // 3 -> 4
        for(int i = r/2 ; i < r ; i++) {
            for(int j = c/2 ; j < c ; j++)
                tmp[i][j - c/2] = map[i][j];
        }

        // 4 -> 1
        for(int i = r/2 ; i < r ; i++) {
            for(int j = 0 ; j < c/2 ; j++)
                tmp[i - r/2][j] = map[i][j];
        }

        map = tmp.clone();
    }

    // 6. 반시계 방향 회전
    private static void move6() {
        tmp = new int[r][c];

        // 1 -> 4
        for(int i = 0 ; i < r/2 ; i++) {
            for(int j = 0 ; j < c/2 ; j++)
                tmp[i + r/2][j] = map[i][j];
        }

        // 2 -> 1
        for(int i = 0 ; i < r/2 ; i++) {
            for(int j = c/2 ; j < c ; j++)
                tmp[i][j - c/2] = map[i][j];
        }

        // 3 -> 2
        for(int i = r/2 ; i < r ; i++) {
            for(int j = c/2 ; j < c ; j++)
                tmp[i - r/2][j] = map[i][j];
        }

        // 4 -> 3
        for(int i = r/2 ; i < r ; i++) {
            for(int j = 0 ; j < c/2 ; j++)
                tmp[i][j + c/2] = map[i][j];
        }

        map = tmp.clone();
    }

    private static void print() {
        StringBuilder sb = new StringBuilder();

        for(int[] i : map) {
            for(int j : i) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
