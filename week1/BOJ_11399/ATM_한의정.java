import java.util.*;
import java.io.*;

public class ATM_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 시간 순 오름차순 정렬

        int total = arr[0]; // 전체 소요 시간
        for(int i = 1 ; i < N ; i++) {
            arr[i] += arr[i - 1];   // 이전 시간 누적해 저장
            total += arr[i];
        }

        System.out.println(total);
    }
}
