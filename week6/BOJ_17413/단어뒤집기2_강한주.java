import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Stack<Character> stk1 = new Stack<>();
    static Stack<Character> stk2 = new Stack<>();
    static int stkNum = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String input = br.readLine();


        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch=='<'){//<가 나오면 stkNum=2인 스택을 사용한다
                stkNum = 2;
            }

            if(stkNum == 1){
                stk1.push(ch);
                if(ch==' ' || i==input.length()-1){//stk1 스택을 꺼낼 조건
                    if(ch==' ')stk1.pop();
                    while(stk1.size()>0){
                        char c = stk1.pop();
                        System.out.print(c);
                    }
                    System.out.print(" ");
                }
            }else{//stkNum==2
                stk2.push(ch);
                if(ch=='>'){//stk2 스택을 꺼낼조건
                    while(stk2.size()>0){
                        char c = stk2.remove(0);
                        System.out.print(c);
                    }
                    stkNum = 1;
                }else if(ch=='<'){//stk1 스택을 꺼낼조건
                    while(stk1.size()>0){
                        char c = stk1.pop();
                        System.out.print(c);
                    }
                }
            }
        }

    }
}