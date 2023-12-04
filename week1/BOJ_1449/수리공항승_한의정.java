import java.util.*;
import java.io.*;

public class 수리공항승_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N]; // 물 새는 곳 위치 배열
        boolean[] visited = new boolean[1001];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);   // 오름차순 정렬

        int cnt = 0;
        for(int i = 0 ; i < N ; i++) {
            // 이미 메꿔져 있으면 패스
            if(visited[arr[i]])  continue;

            // 메꿔져 있지 않으면 메꾸기 (단, 최대 위치 1000을 넘지 않도록)
            cnt++;
            for(int j = arr[i] ; (j < arr[i] + L) && j <= 1000 ; j++) {
                if(!visited[j]) {
                    visited[j] = true;
                }
            }
        }

        System.out.println(cnt);
    }
}