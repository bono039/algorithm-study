import java.util.*;
import java.io.*;

public class 괄호의값_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] ch = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        int num = 1;

        for(int i = 0 ; i < ch.length ; i++) {
            if(ch[i] == '(') {
                stack.push('(');
                num *= 2;
            }
            else if(ch[i] == ')') {
                if(stack.isEmpty()) {
                    result = 0;
                    break;
                }

                char beforeC = stack.pop();
                if(beforeC != '(') {
                    result = 0;
                    break;
                }
                else {
                    // 현재 idx 바로 전 idx - 1번째 문자가 여는 괄호일 경우에만 더함
                    if(ch[i - 1] == '(') {
                        result += num;
                    }
                    num /= 2;
                }
            }
            else if(ch[i] == '[') {
                stack.push('[');
                num *= 3;
            }
            else if(ch[i] == ']') {
                if(stack.isEmpty()) {
                    result = 0;
                    break;
                }

                char beforeC = stack.pop();
                if(beforeC != '[') {
                    result = 0;
                    break;
                }
                else {
                    // 현재 idx 바로 전 idx - 1번째 문자가 여는 괄호일 경우에만 더함
                    if(ch[i - 1] == '[') {
                        result += num;
                    }
                    num /= 3;
                }
            }
        }

        System.out.println(!stack.isEmpty() ? 0 : result);
    }
}
