import java.util.*;
import java.io.*;

public class 단어맞추기_한의정 {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            solve(br.readLine());
        }

        System.out.println(sb.toString());
    }

    private static void solve(String str) {
        int len = str.length();
        char[] ch = str.toCharArray();

        int idx1 = -1;  // 처음으로 감소하는 원소 위치
        int idx2 = 0;   // idx1에서 찾은 원소보다 처음으로 큰 원소 위치

        // 1. 맨 뒤에서부터 확인하며 처음으로 감소하는 위치 idx1 찾기
        for(int i = len - 1 ; i > 0 ; i--) {
            if(ch[i - 1] < ch[i]) {
                idx1 = i - 1;
                break;
            }
        }

        if(idx1 == -1) {
            sb.append(str).append("\n");
            return;
        }

        // 2. 다시 맨 뒤에서부터 확인하며 idx1보다 큰 위치 idx2 찾기
        for(int i = len - 1 ; i >= 0 ; i--) {
            if(ch[idx1] < ch[i]) {
                idx2 = i;
                break;
            }
        }

        // 3. idx1과 idx2에 위치한 원소를 swap하기
        char tmp = ch[idx1];
        ch[idx1] = ch[idx2];
        ch[idx2] = tmp;

        // 4. idx1 + 1부터 끝까지 뒷 부분을 오름차순 정렬하기
        Arrays.sort(ch, idx1 + 1, len);

        for(char c : ch)
            sb.append(c);
        sb.append("\n");
    }
}
