import java.util.*;
import java.io.*;

public class 괄호_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {    // = for문 T번 돌리기
            String str = br.readLine();

            sb.append(solve(str) ? "YES" : "NO");   // 해당 메소드가 true면 YES, false면 NO 출력
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // 스택이 비어 있는지 판별하는 메소드 (비면 true / 안 비면 false 출력)
    private static boolean solve(String str) {
        char[] ch = str.toCharArray();  // 입력 받은 문자열을 char형 배열로 변환
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < ch.length ; i++) {
            if(ch[i] == '(') {
                stack.push('(');
            }
            else {
                // 스택이 비어 있지 않고, 마지막 값이 '('라면 마지막 원소 제거
                if(!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
                else {
                    stack.push(ch[i]);
                }
            }
        }

        // 스택이 비어 있으면 true 출력
        if(stack.isEmpty())
            return true;
        // 안 비어있으면 false 출력
        return false;
    }
}
