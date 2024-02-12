import java.util.*;
import java.io.*;

public class 링크와스타트_한의정 {
    static int N;
    static int[][] S;
    static boolean[] chk;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        chk = new boolean[N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(min);
    }

    private static void dfs(int cnt) {
        if(cnt == N) {  // [종료 조건] 마지막 원소까지 부분집합에 다 고려되었을 때
            int start = 0;
            int link = 0;

            for(int i = 0 ; i < N ; i++) {
                for(int j = i + 1 ; j < N ; j++) {
                    if(chk[i] != chk[j])   continue;

                    if(chk[i])  start += S[i][j] + S[j][i];
                    else        link  += S[i][j] + S[j][i];
                }
            }

            min = Math.min(min, Math.abs(start - link));
            return;
        }

        // 해당 원소 선택
        chk[cnt] = true;
        dfs(cnt + 1);

        // 해당 원소 비선택
        chk[cnt] = false;
        dfs(cnt + 1);
    }
}
