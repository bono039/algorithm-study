import java.util.*;
import java.io.*;

public class 괄호추가하기_한의정 {
    static int answer = Integer.MIN_VALUE;
    static List<Integer> numList = new ArrayList<>();   // 숫자 리스트
    static List<Character> opList = new ArrayList<>();  // 연산자 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] ch = br.readLine().toCharArray();

        for(char c : ch) {
            if(Character.isDigit(c)) numList.add(c - '0');
            else                     opList.add(c);
        }

        dfs(numList.get(0), 0);
        System.out.println(answer);
    }

    // 괄호로 묶을지, 안 묶을지 판단하는 메소드 (백트래킹)
    private static void dfs(int num, int depth) {
        // 주어진 연산자 갯수만큼 뽑았으면 정답 갱신
        if(depth == opList.size()) {
            answer = Math.max(answer, num);
            return;
        }

        // 1) 괄호 안 치고 넘기는 경우
        int n1 = calc(num, numList.get(depth + 1), opList.get(depth));
        dfs(n1, depth + 1);

        // 2) 괄호 치고 넘기는 경우 (뒤쪽에서부터)
        if(depth + 1 < opList.size()) {
            int n2 = calc(numList.get(depth + 1), numList.get(depth + 2), opList.get(depth + 1));
            dfs(calc(num, n2, opList.get(depth)), depth + 2);
        }
    }

    // 연산 메소드
    private static int calc(int a, int b, char op) {
        if(op == '+')        return a+b;
        else if(op == '-')   return a-b;
        else if(op == '*')   return a*b;

        return -1;
    }
}
