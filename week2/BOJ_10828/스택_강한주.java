import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();

        for(int i = 0; i < n; i++){
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            String order = tokenizer.nextToken();

            if(order.equals("push")){
                int x = Integer.parseInt(tokenizer.nextToken());
                stk.push(x);
            }else if(order.equals("pop")){
                if(stk.isEmpty()==true) {
                    System.out.println("-1");
                }else {
                    System.out.println(stk.pop());
                }
            }else if(order.equals("size")){
                System.out.println(stk.size());
            }else if(order.equals("empty")){
                System.out.println(stk.isEmpty() == true? "1":"0");
            }else {
                if(stk.isEmpty()==true) {
                    System.out.println("-1");
                }else {
                    System.out.println(stk.peek());
                }

            }
        }


    }

}