import java.util.*;
import java.io.*;

public class 캠프준비_한의정 {
    static int N,L,R,X;
    static Node[] arr;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());   // 최저
        R = Integer.parseInt(st.nextToken());   // 최고
        X = Integer.parseInt(st.nextToken());   // 최저 난이도 차

        arr = new Node[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);   // 난이도 기준 오름차순 정렬

        // 캠프에 사용할 문제 2개 이상 고르기
        for(int i = 2 ; i <= N ; i++) {
            visited = new boolean[N];
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    private static void dfs(int target, int cnt) {
        // [종료 조건] 목표 갯수만큼 뽑았으면 조건 만족하는지 확인하고 방법 수 갱신
        if(cnt == target) {
            int sum = 0;

            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < N ; i++) {
                if(visited[i]) {
                    list.add(i);
                    sum += arr[i].lv;
                }
            }

            int diff = arr[list.get(list.size() -1)].lv - arr[list.get(0)].lv;
            if(sum >= L && sum <= R && (diff >= X)) {   // 1번 조건과 2번 조건 성립하는지 확인
                answer++;
            }

            return;
        }

        for(int i = cnt ; i < N ; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(target, i + 1);
                visited[i] = false;
            }
        }
    }
}
class Node implements Comparable<Node> {
    int idx, lv;

    public Node(int idx, int lv) {
        this.idx = idx;
        this.lv = lv;
    }

    // 난이도 기준 오름차순 정렬
    @Override
    public int compareTo(Node n) {
        return this.lv - n.lv;
    }
}