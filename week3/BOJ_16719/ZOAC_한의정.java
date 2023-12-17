import java.util.*;
import java.io.*;

public class ZOAC_한의정 {
    static String str;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        visited = new boolean[str.length()];

        zoac(0, str.length() - 1);  // 처음 시작할 부분, 끝내는 부분
        System.out.println(sb);
    }

    private static void zoac(int left, int right) {  // 처음 시작할 부분, 끝내는 부분
        if(left > right)    return;

        // 해당 구간에 있는 문자들 中 사전식 순서가 가장 낮은 글자 찾기
        int idx = left;
        for(int i = left ; i <= right ; i++) {
            if(str.charAt(idx) > str.charAt(i)) {
                idx = i;
            }
        }
        visited[idx] = true;

        for(int i = 0 ; i < str.length() ; i++) {
            if(visited[i]) {
                sb.append(str.charAt(i));
            }
        }
        sb.append("\n");

        // 사전식 순서 맞추기 (반드시 재귀 이 순서로!)
        zoac(idx + 1, right);   // 현재 문자보다 뒤에 있는 문자열 탐색
        zoac(left, idx - 1);    // 현재 문자보다 앞에 있는 문자열 탐색
    }
}
