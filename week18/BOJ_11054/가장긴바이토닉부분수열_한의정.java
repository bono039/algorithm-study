import java.util.*;
import java.io.*;

public class 가장긴바이토닉부분수열_한의정 {
    static int N;
    static int[] arr, dp1, dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp1 = new int[N + 1];
        dp2 = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp1[i] = 1;
            dp2[i] = 1;
        }

        LIS();  // 최장 증가 부분 수열 (L → R)
        LDS();  // 최장 감소 부분 수열 (L ← R)

        int max = 0;
        for(int i = 1 ; i <= N ; i++) {
            if(max < dp1[i] + dp2[i]) {
                max = dp1[i] + dp2[i];
            }
        }

        System.out.println(max - 1);    // 중복되는 값 1개 빼주기
    }

    // 최장 증가 부분 수열 (L → R)
    private static void LIS() {
        for(int i = 1 ; i <= N ; i++) {
            for(int j = 1 ; j < i ; j++) {  // 비교 대상 : 1 ~ i-1번 원소
                if(arr[i] <= arr[j])    continue;

                if(dp1[i] < dp1[j] + 1)
                    dp1[i] = dp1[j] + 1;
            }
        }
    }

    // 최장 감소 부분 수열 (L ← R)
    private static void LDS() {
        for(int i = N ; i >= 1; i--) {  // 맨 뒤에서부터 시작
            for(int j = N ; j > i ; j--) {  // 맨 뒤에서 i 이전 원소들 탐색
                if(arr[i] <= arr[j])    continue;

                if(dp2[i] < dp2[j] + 1)
                    dp2[i] = dp2[j] + 1;
            }
        }
    }
}
