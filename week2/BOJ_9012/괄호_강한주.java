import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            String str = sc.next();
            boolean ans = isVPS(str);
            System.out.println(ans==true?"YES":"NO");
        }
    }

    static boolean isVPS(String str){
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='('){
                stk.push('(');
            }else{
                if(stk.isEmpty()){
                    return false;
                }else{
                    stk.pop();
                }
            }
        }

        if(stk.isEmpty())return true;
        else return false;

    }
}
