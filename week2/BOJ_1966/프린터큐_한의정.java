import java.util.*;
import java.io.*;

public class 프린터큐_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());   // 문서 개수
            int M = Integer.parseInt(st.nextToken());   // 몇 번쨰로 인쇄되었는지 궁금한 문서

            LinkedList<Node> q = new LinkedList<>();    // 큐를 LinkedList로 선언해 get 메소드 사용

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < N ; i++) {
                q.add(new Node(i, Integer.parseInt(st.nextToken())));   // 객체에 (위치, 중요도) 저장
            }

            int cnt = 0;

            while(!q.isEmpty()) {
                boolean isMax = true;   // 맨 앞 원소의 중요도가 가장 큰지 확인용 변수
                Node first = q.poll();  // 맨 앞 원소

                // 큐에 남은 원소들과 중요도 비교
                for(int i = 0 ; i < q.size() ; i++) {
                    // 뒤쪽에 더 큰 중요도를 가진 원소가 있다면,
                    // 뽑은 원소와, i번째 이전까지의 원소들을 모두 뒤로 보냄
                    if(first.val < q.get(i).val) {
                        q.add(first);

                        for(int j = 0 ; j < i ; j++) {
                            q.add(q.poll());
                        }

                        isMax = false;
                        break;
                    }
                }

                // 맨 앞 원소의 중요도가 가장 큰 경우
                if(isMax) {
                    cnt++;
                    if(first.idx == M) break;
                }
            }
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}

class Node {
    int idx, val;   // (위치, 중요도)

    public Node(int idx, int val) {
        this.idx = idx;
        this.val = val;
    }
}
