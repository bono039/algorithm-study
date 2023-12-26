import java.util.*;
import java.io.*;

public class 달력_한의정 {
    static int DAY_OF_YEAR = 365;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] cntArr = new int[DAY_OF_YEAR + 1];

        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 구간 색칠하기
            for(int i = from ; i <= to ; i++) {
                cntArr[i]++;
            }
        }

        int total = 0;
        int w = 0;
        int maxH = 0;

        for(int i = 0 ; i <= DAY_OF_YEAR ; i++) {
            if(cntArr[i] != 0) {
                w++;
                maxH = Math.max(maxH, cntArr[i]);
            }
            else {
                total += w * maxH;

                // 너비와 최대 높이 초기화
                w = 0;
                maxH = 0;
            }
        }

        total += w * maxH;  // 마지막꺼
        System.out.println(total);
    }
}