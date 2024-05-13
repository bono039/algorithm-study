import java.util.*;
import java.io.*;

public class 로프_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 로프 수

        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE; // 로프들을 이용해 들어올릴 수 있는 물체의 최대 중량
        for(int k = 0 ; k < N ; k++) {
            max = Math.max(max, arr[k] * (N - k));  // 본인 뒤에 있는 원소들 모두 병렬로 연결하기
        }

        System.out.println(max);
    }
}
