import java.util.*;
import java.io.*;

public class 홀수홀릭호석_한의정 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cut(N, getOdd(N));
        System.out.println(min + " " + max);
    }

    // 자르고, 홀수 갯수 구하는 함수 (재귀!)
    private static void cut(int n, int total) {
        if(n < 10) {        // 한 자리 수인 경우
            min = Math.min(min, total);
            max = Math.max(max, total);
        }
        else if(n < 100) {  // 두 자리 수인 경우
            int sum = (n / 10) + (n % 10);
            cut(sum, total + getOdd(sum));
        }
        else {              // 세 자리 이상 수인 경우
            String str = Integer.toString(n);
            int len = str.length();

            // 완전탐색으로 숫자 3등분하는 모든 경우의 수 구하고, 홀수 갯수 구하는 데 활용하기
            for(int i = 0 ; i < len - 2 ; i++) {
                for(int j = i + 1 ; j < len - 1 ; j++) {

                    String s1 = str.substring(0, i + 1);
                    String s2 = str.substring(i + 1, j + 1);
                    String s3 = str.substring(j + 1, len);

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    cut(sum, total + getOdd(sum));
                }
            }
        }
    }

    // 홀수 갯수 구하는 함수
    private static int getOdd(int num) {
        int cnt = 0;

        while(num > 0) {
            int cur = num % 10;

            if(cur % 2 == 1)    cnt++;
            num /= 10;
        }

        return cnt;
    }
}