import java.util.*;
import java.io.*;

public class 주유소_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[] dist = new long[N-1];    // 인접한 두 도시를 연결하는 도로의 길이
        long[] gas = new long[N];       // 주유소 리터 당 가격

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N-1 ; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            gas[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long min = gas[0];  // 낮은 주유 가격

        for(int i = 0 ; i < dist.length ; i++) {
            // 주유 가격 비교해 더 낮은 주유 가격만큼 주유
            if(gas[i] < min) {
                min = gas[i];
            }

            sum += min * dist[i];
        }

        System.out.println(sum);
    }
}
