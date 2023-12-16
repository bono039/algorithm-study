import java.util.*;
import java.io.*;

class Pair {
    int start, end; //괄호의 시작과 끝 index

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class 괄호제거_한의정 {
    static char[] ch;

    static List<Pair> list = new ArrayList<>();
    static Set<String> result = new TreeSet<>();
    static boolean[] check; // 쌍 맺는 괄호 지울지 판단하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ch = br.readLine().toCharArray(); //읽은 문자열을 char형 배열로 바꾼다

        // 1. 괄호 쌍 구하기
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < ch.length ; i++) {
            if(ch[i] == '(') {
                stack.push(i);
            }
            else if(ch[i] == ')') {
                list.add(new Pair(stack.pop(), i));
            }
        }

        // 2. 괄호 존재여부 모든 조합 구하기
        check = new boolean[ch.length]; //ex) 처음에 다 false
        comb(0);

        // 출력하기
        Iterator<String> iter = result.iterator();  // set을 iterator 안에 담기
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private static void comb(int depth) {
        if(depth == list.size()) { // list.size = 괄호 쌍의 갯수
            boolean b = false;

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < ch.length ; i++) {
                if(!check[i]) {// check[i] = false면
                    sb.append(ch[i]);
                }
                else {//check[i] = true면 즉, 괄호가 제거 되어있는게 있다면
                    b = true;
                }
            }

            if(b) {
                result.add(sb.toString());
            }
            return;
        }

        // 현재 괄호 제거 안 함
        comb(depth + 1);

        // 현재 괄호 제거
        Pair now = list.get(depth);
        check[now.start] = true;
        check[now.end] = true;
        comb(depth + 1);
        check[now.start] = false;
        check[now.end] = false;
    }
}

