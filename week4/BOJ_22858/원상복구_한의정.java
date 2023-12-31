import java.util.*;
import java.io.*;

public class 원상복구_한의정 {
    static int N, K;
    static int[] arr, D, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // K번 카드 섞은 배열
        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // D 배열
        D = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            D[i] = Integer.parseInt(st.nextToken());
        }

        while(K --> 0) {
            // 임의의 배열 생성
            tmp = new int[N + 1];

            // K번 섞은 배열의 값을 임의의 배열에 값에 넣음 (역순)
            for(int i = 1 ; i <= N ; i++) {
                tmp[D[i]] = arr[i];
            }

            // 원래 배열에 넣음
            arr = tmp;
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i <= N ; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
