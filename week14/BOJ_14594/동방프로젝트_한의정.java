import java.util.*;
import java.io.*;

public class 동방프로젝트_한의정 {
    static int N,M;
    static boolean[] walls; // true: 벽 무너짐, false: 벽 있음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        walls = new boolean[N];   // 1 ~ (N-1)개

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x < y) {
                breakWall(x, y);
            }
        }

        int cnt = 0;
        for(int i = 1 ; i < N ; i++) {
            if(!walls[i])
                cnt++;
        }

        System.out.println(cnt + 1);    // 방 수 = 벽 수 +1
    }

    private static void breakWall(int x, int y) {
        for(int i = x ; i < y ; i++) {
            if(!walls[i])
                walls[i] = true;
        }
    }
}
