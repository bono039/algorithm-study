import java.util.*;
import java.io.*;

public class 단어뒤집기2_한의정 {
    // 문자열 거꾸로 출력하는 메소드 → 스택 활용 !
    private static void print(Stack st) {
        while(!st.isEmpty()) {
            System.out.print(st.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        boolean check = false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == '<') {  // < 만나면 여태 저장해둔 문자열 거꾸로 출력
                print(stack);
                check = true;
                System.out.print(str.charAt(i));
            }
            else if(str.charAt(i) == '>') {
                check = false;
                System.out.print(str.charAt(i));
            }
            else if(check) {
                System.out.print(str.charAt(i));
            }
            else {
                if(str.charAt(i) == ' ') {
                    print(stack);
                    System.out.print(str.charAt(i));
                }
                else {
                    stack.push(str.charAt(i));
                }
            }
        }

        print(stack);
    }
}
