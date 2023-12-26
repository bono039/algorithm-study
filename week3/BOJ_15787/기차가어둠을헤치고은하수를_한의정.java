import java.util.*;
import java.io.*;

public class 기차가어둠을헤치고은하수를_한의정 {
    static int N, M;
    static int[][] trains;
    static Set<String> set = new HashSet<>();   // 열차 상태 저장 집합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 기차 수
        M = Integer.parseInt(st.nextToken());   // 명령 수

        trains = new int[N + 1][21];

        while(M --> 0) {
            String[] str = br.readLine().split(" ");

            int cmd = Integer.parseInt(str[0]);
            int train = Integer.parseInt(str[1]);

            if(str.length == 2) {
                move(cmd, train);
            }
            else {
                int seat = Integer.parseInt(str[2]);
                solve(cmd, train, seat);
            }
        }

        // 열차 상태를 문자열로 변경해 Set에 저장
        for(int i = 1 ; i <= N ; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 1 ; j <= 20 ; j++) {
                sb.append(trains[i][j] + " ");
            }
            set.add(sb.toString());
        }

        // set 크기 구하기 (set은 자동 중복 제거)
        System.out.println(set.size());
    }

    private static void solve(int cmd, int tIdx, int seat) {
        if(cmd == 1) {
            trains[tIdx][seat] = 1;
        }
        else if(cmd == 2) {
            trains[tIdx][seat] = 0;
        }

        return;
    }

    private static void move(int cmd, int tIdx) {
        if(cmd == 3) {  // 모두 한 칸씩 뒤로 이동
            for(int i = 20 ; i > 1 ; i--) {
                trains[tIdx][i] = trains[tIdx][i - 1];
            }
            trains[tIdx][1] = 0;
        }
        else if(cmd == 4) { // 모두 한 칸씩 앞으로 이동
            for(int i = 1 ; i < 20 ; i++) {
                trains[tIdx][i] = trains[tIdx][i + 1];
            }
            trains[tIdx][20] = 0;
        }

        return;
    }
}