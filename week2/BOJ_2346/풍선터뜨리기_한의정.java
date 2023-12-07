import java.util.*;
import java.io.*;

public class 풍선터뜨리기_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Balloon> dq = new ArrayDeque<>();    // LinkedList로 하면 메모리 초과

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            dq.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }

        while(!dq.isEmpty()) {
            // 덱 맨 앞에 있는 풍선 번호 저장하고, 꺼내서 적힌 값 저장
            sb.append(dq.getFirst().idx + " ");
            int next = dq.poll().val;

            // 남아있는 풍선 없으면 종료
            if(dq.isEmpty()) break;

            // 적힌 값이 양수인 경우
            if(next > 0) {
                for(int i = 0 ; i < next - 1 ; i++) {
                    dq.addLast(dq.pollFirst());
                }
            }
            // 적힌 값이 음수인 경우
            else {
                for(int i = 0 ; i < Math.abs(next) ; i++) {
                    dq.addFirst(dq.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}

class Balloon {
    int idx, val;

    public Balloon(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}
