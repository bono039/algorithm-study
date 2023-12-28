import java.util.*;
import java.io.*;

public class 오리_한의정 {
    static char[] duck = {'q', 'u', 'a','c', 'k'};

    static char[] ch;   // 울음소리 배열
    static boolean[] visited;

    static int idx = 0;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ch = br.readLine().toCharArray();
        visited = new boolean[ch.length];

        // 첫 번째 값이 'q'로 시작하지 않거나, 배열 길이가 5의 배수가 아닌 경우 -1
        if(ch[0] != 'q' || ch.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        for(int i = 0 ; i < ch.length ; i++) {
            List<Character> list = new ArrayList<>();   // 울음소리 저장 리스트

            for(int j = i ; j < ch.length ; j++) {
                // 방문 안 한 울음소리가 duck 배열 순서를 지키는지 확인
                if(!visited[j] && ch[j] == duck[idx]) {
                    idx++;
                    list.add(ch[j]);
                    visited[j] = true;

                    if(idx == 5) {
                        idx = 0;
                    }
                }
            }

            if(list.size() != 0) {
                // 리스트의 마지막 값이 k가 아니라면 제대로 운 게 아니니까 -1 리턴
                if(list.get(list.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }

                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
