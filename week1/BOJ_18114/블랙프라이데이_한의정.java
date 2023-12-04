import java.util.*;
import java.io.*;

public class 블랙프라이데이_한의정 {
    static int N, C;
    static List<Integer> w = new ArrayList<>();
    static boolean exists = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            w.add(Integer.parseInt(st.nextToken()));

            if(w.get(i) == C) {
                System.out.println(1);
                return;
            }
        }
        Collections.sort(w);   // 이진 탐색 위해 오름차순 정렬

        int start = 0;
        int end = N - 1;
        int weight;

        while(start < end) {
            // 물건 2개 골라놓기
            weight = w.get(start) + w.get(end);

            if(weight > C) {
                end--;
            }
            else if(weight == C) {
                System.out.println(1);
                return;
            }
            else {
                if(start < w.indexOf(C - weight) && w.indexOf(C - weight) < end) {
                    System.out.println(1);
                    return;
                }
                start++;
            }
        }

        System.out.println(0);
    }
}