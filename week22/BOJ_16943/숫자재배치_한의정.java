import java.util.*;
import java.io.*;

public class 숫자재배치_한의정 {
    static String[] str;
    static int A,B, N;

    static boolean[] chk;   // 정수 A에 포함된 숫자를 사용할지 나타내는 배열
    static List<Integer> list = new ArrayList<>();  // 뽑은 숫자 저장 리스트

    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine().split(" ");
        A = Integer.parseInt(str[0]);
        B = Integer.parseInt(str[1]);

        N = str[0].length();    // 최대 자릿수
        chk = new boolean[N];

        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int depth) {
        if(depth == N) {    // 최대 자릿수 N개만큼 뽑았을 때 결과값 비교
            StringBuilder tmp = new StringBuilder();
            for(int i : list) {
                tmp.append(i);
            }

            // 0으로 시작하면 패스
            if(tmp.charAt(0) == '0')    return;

            int num = Integer.parseInt(tmp.toString());
            if(num < B) {   // 0으로 시작하지 않고, B보다 작으면 정답을 더 큰 값으로 갱신
                answer = Math.max(answer, num);
            }

            return;
        }

        // 반복문으로 각 자리의 숫자 뽑기
        for(int i = 0 ; i < N ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                list.add(str[0].charAt(i) - '0');
                dfs(i+1, depth+1);
                chk[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
