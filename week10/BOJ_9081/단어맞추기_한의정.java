import java.util.*;
import java.io.*;

public class 단어맞추기_한의정 {
    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            findNextWord(br.readLine());
        }

        System.out.println(sb.toString());
    }

    private static void findNextWord(String str) {
        int len = str.length();
        char[] ch = str.toCharArray();

        int idx1 = -1;
        int idx2 = 0;

        // 1) 맨 뒤에서부터 확인하며 감소하는 부분 찾기
        for(int i = len - 1 ; i > 0 ; i--) {
            if(ch[i - 1] < ch[i]) {
                idx1 = i - 1;
                break;
            }
        }

        if(idx1 == -1) {    // 감소하는 부분 없으면 마지막 단어니까 문자열 그대로
            sb.append(str).append("\n");
            return;
        }

        // 2) 다시 맨 뒤에서부터 확인하며 감소하는 부분보다 큰 부분 찾기
        for(int i = len - 1 ; i >= 0 ; i--) {
            if(ch[idx1] < ch[i]) {
                idx2 = i;
                break;
            }
        }

        // 3) 둘의 위치 swap하기
        char tmp = ch[idx1];
        ch[idx1] = ch[idx2];
        ch[idx2] = tmp;

        Arrays.sort(ch, idx1 + 1, len); // 4) 1의 위치 뒷 부분 정렬

        for(char c : ch)
            sb.append(c);
        sb.append("\n");
    }
}
