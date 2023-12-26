package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stk = new Stack<>();
        String str = sc.next();

        int ans = 0;
        int tmp = 1;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(c == '(' || c == '['){
                stk.push(c);
                tmp *= (c=='('? 2: 3);
            }
            else{// ),]일 경우
                if(stk.isEmpty()){
                    ans = 0;
                    break;
                }

                char beforeChar = stk.pop();
                if(c == ')'){
                    if(beforeChar != '('){
                        ans = 0;
                        break;
                    }else{
                        if(str.charAt(i-1) == '(')
                            ans += tmp;
                        tmp /= 2;
                    }
                }else{ //c == ']'
                    if(beforeChar != '['){
                        ans = 0;
                        break;
                    }else{
                        if(str.charAt(i-1) == '[')
                            ans += tmp;
                        tmp /= 3;
                    }
                }
            }
        }

        if(!stk.isEmpty())ans = 0;

        System.out.println(ans);


    }
}
