import java.util.*;
import java.io.*;

public class 두용액_강한주 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] kinds = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            kinds[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(kinds);

        int low = 0;
        int high = kinds.length - 1;
        int min = Integer.MAX_VALUE;

        int ans1 = 0;
        int ans2 = 0;

        while(low<high) {

            int sum = kinds[low]+kinds[high];

            if(Math.abs(sum) < min) {
                ans1 = kinds[low];
                ans2 = kinds[high];
                min = Math.abs(sum);
            }

            if(sum > 0) {
                high--; //이부분 때문에 틀림
            }else {
                low++;
            }
        }

        System.out.println(ans1+" "+ans2);

//아래처럼 생각해서 틀림, 이분탐색을 더 연습해야겠다
//        if (start > 0 && end > 0) {//산성이면
//            end = list.get(1);
//            System.out.println(start + " " + end);
//        } else if (start < 0 && end < 0) {//알칼리성이면
//            start = list.get(list.size() - 2);
//            System.out.println(start + " " + end);
//        } else {
//            System.out.println(start + " " + end);
//        }

    }

}
