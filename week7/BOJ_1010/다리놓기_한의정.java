import java.util.*;
import java.io.*;

public class 다리놓기_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long[][] bridge = new long[31][31]; // 조합 배열

        // 조합 배열 초기값 미리 채워두기
        for(int i = 0 ; i <= 30 ; i++) {
            bridge[i][0] = 1;   // i개 중 0개 뽑는 경우의 수 : 1
            bridge[i][1] = i;   // i개 중 1개 뽑는 경우의 수 : i
            bridge[i][i] = 1;   // i개 중 i개 뽑는 경우의 수 : 1
        }

        // 나머지 칸 채우기
        // mCn : arr[m][n] = arr[m - 1][n] + arr[m - 1][n - 1];
        for(int i = 2 ; i <= 30 ; i++) {
            for(int j = 1 ; j < i ; j++) {
                bridge[i][j] = bridge[i - 1][j] + bridge[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());   // 서
            int M = Integer.parseInt(st.nextToken());   // 동

            sb.append(bridge[M][N] + "\n"); // 조합 : mCn
        }

        System.out.println(sb);
        br.close();
    }
}
