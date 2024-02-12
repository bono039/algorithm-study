import java.util.*;
import java.io.*;

public class 숫자야구_한의정 {
    static int N;
    static Node[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new Node[N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[i] = new Node(n, s, b);
        }

        System.out.println(calBaseball());
    }

    private static int calBaseball() {
        int result = 0;

        for(int i = 123 ; i <= 987 ; i++) {
            if(!isSame(i))  continue;   // 중복 숫자 처리

            int allTestPass = 0;

            // 해당 숫자가 조건 만족하는지 확인
            for(int j = 0 ; j < N ; j++) {
                int sCnt = 0;
                int bCnt = 0;

                Node now = arr[j];
                String curStr = Integer.toString(now.num);
                String myDataStr = Integer.toString(i);

                // 스트라이크 수 확인
                for(int idx = 0 ; idx < 3 ; idx++) {
                    if(curStr.charAt(idx) == myDataStr.charAt(idx))
                        sCnt++;
                }

                // 볼 수 확인
                for(int b = 0 ; b < 3 ; b++) {
                    for(int c = 0 ; c < 3 ; c++) {
                        if(b == c) continue;
                        if(curStr.charAt(c) == myDataStr.charAt(b)) {
                            bCnt++;
                        }
                    }
                }

                if(now.strike == sCnt && now.ball == bCnt) {
                    allTestPass++;
                }
            }

            if(allTestPass == N) {
                result++;
            }
        }

        return result;
    }

    // 중복되는 숫자가 있거나 0 포함하는지 확인하는 함수
    private static boolean isSame(int number) {
        String numStr = Integer.toString(number);

        if(numStr.charAt(0) == numStr.charAt(1))    return false;
        if(numStr.charAt(1) == numStr.charAt(2))    return false;
        if(numStr.charAt(0) == numStr.charAt(2))    return false;
        if(numStr.charAt(0) == '0' || numStr.charAt(1) == '0' || numStr.charAt(2) == '0')    return false;

        return true;
    }
}

class Node {
    int num, strike, ball;

    public Node(int num, int strike, int ball) {
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }
}
