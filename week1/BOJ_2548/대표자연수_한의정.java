import java.util.*;
import java.io.*;

public class 대표자연수_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));

        int N = Integer.parseInt((br.readLine()));

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 중앙값 탐색 위해 정렬

        // 대표 자연수 : 중앙값
        // 배열의 길이가 짝수와 홀수인 경우에 따라 중앙값 인덱스가 다르므로 조정
        int mid = (arr.length % 2 == 0) ? arr[arr.length / 2 - 1] : arr[arr.length / 2];
        System.out.println(mid);
    }
}
