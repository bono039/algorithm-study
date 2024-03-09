import java.util.*;
import java.io.*;

public class 가장큰증가하는부분수열_한의정 {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N];
        for(int i = 0 ; i < N ; i++) {  // 기준값
            dp[i] = arr[i]; // 초기값은 배열 값 그대로 저장

            for(int j = 0 ; j < i ; j++) {  // 기준값 앞쪽 확인하기
                if(arr[j] < arr[i]) {   // 기준값 앞쪽에 기준값보다 작은 값이 존재한다면 갱신
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        Arrays.sort(dp);    // 최댓값 찾기 위해 오름차순 정렬
        System.out.println(dp[N-1]);    // 최댓값 출력
    }
}
