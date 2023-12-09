import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stk = new Stack<>();

        String str = sc.next();
        int ans = 0;

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '('){
                stk.push('(');
            }else{
                stk.pop();

                if(str.charAt(i-1) == '('){
                    ans += stk.size();
                }else{
                    ans += 1;
                }
            }
        }

        System.out.print(ans);

    }
}
