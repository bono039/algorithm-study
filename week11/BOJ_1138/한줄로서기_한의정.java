import java.util.*;
import java.io.*;

public class 한줄로서기_한의정 {
    static int N;
    static int[] arr;
    static List<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 큰 순으로 입력받은 키대로 List에 삽입하기
        for(int i = N ; i >= 1 ; i--) {
            ans.add(arr[i], i); // arr[i]번째에 i 추가
        }

        for(int k : ans) {
            System.out.print(k + " ");
        }
    }
}
