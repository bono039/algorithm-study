import java.util.*;
import java.io.*;

public class Main {
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int arr[] = new int[W];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i < W ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 1 ; i < W - 1 ; i++) {
            int left = 0;
            int right = 0;

            // 왼쪽 최대벽 높이 탐색
            for(int j = 0 ; j < i ; j++) {
                left = Math.max(left, arr[j]);
            }

            // 오른쪽 최대벽 높이 탐색
            for(int j = i + 1 ; j < W ; j++) {
                right = Math.max(right, arr[j]);
            }

            // 현재 벽보다 높은 벽이 양쪽에 있을 때, 더 낮은 건물 기준으로 빗물이 현재 인덱스에 모임
            if(arr[i] < left && arr[i] < right)
                result += (Math.min(left, right) - arr[i]);
        }

        System.out.println(result);
    }
}