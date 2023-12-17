import java.util.*;
import java.io.*;

public class 쇠막대기_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for(int i = 0 ; i < ch.length ; i++) {
            // 열린 괄호면 스택에 추가
            if(ch[i] == '(') {
                stack.push('(');
            }
            // 닫는 괄호인 경우
            else {
                stack.pop();

                // 그 전 괄호가 열린 괄호면, 이번 닫힌 괄호는 레이저를 의미한다.
                if(ch[i - 1] == '(')
                    cnt += stack.size();    // 현재 스택 사이즈(=열린 괄호 개수)만큼 더한다.
                else    // 쇠막대기인 경우
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
