import java.util.*;
import java.io.*;

public class 두용액_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Liquid[] arr  = new Liquid[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = new Liquid(Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);   // 사용자 정의 정렬

        int[] answer = new int[2];
        int diff = Integer.MAX_VALUE;   // 현재 특성값

        for(int i = 0 ; i < N - 1 ; i++) {
            // 두 용액의 특성값이 현재 특성값보다 작다면 갱신
            if(Math.abs(arr[i].val + arr[i + 1].val) < diff) {
                answer[0] = arr[i].val;
                answer[1] = arr[i + 1].val;

                diff = Math.abs(arr[i].val + arr[i + 1].val);
            }
        }

        Arrays.sort(answer);    // 특성값 오름차순 정렬
        System.out.println(answer[0] + " " + answer[1]);
    }
}

class Liquid implements Comparable<Liquid> {
    int val;

    public Liquid(int val) {
        this.val = val;
    }

    // 절댓값 오름차순 정렬
    @Override
    public int compareTo(Liquid o) {
        return Math.abs(this.val) - Math.abs(o.val);
    }
}
