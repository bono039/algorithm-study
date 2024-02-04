import java.util.*;
import java.io.*;

public class 숨바꼭질3_한의정 {
    static final int INF = 100000;
    static final int MAX_POS = 100000;

    static int N, K;

    static int[] time = new int[MAX_POS + 1];
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    static int minTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N >= K) {
            minTime = N - K;
        }
        else {
            dijkstra();
            minTime = time[K];
        }

        System.out.println(minTime);
    }

    private static void dijkstra() {
        Arrays.fill(time, INF);
        time[N] = 0;
        pq.add(new Node(N, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();

            // 이미 갱신되었으면 제외
            if(time[cur.pos] < cur.time) continue;

            // 바로 앞 칸 (+1)
            int np1 = cur.pos - 1;
            if(inRange(np1) && time[np1] > cur.time + 1) {
                time[np1] = cur.time + 1;
                pq.add(new Node(np1, time[np1]));
            }

            // 바로 뒷 칸 (-1)
            int np2 = cur.pos + 1;
            if(inRange(np2) && time[np2] > cur.time + 1) {
                time[np2] = cur.time + 1;
                pq.add(new Node(np2, time[np2]));
            }

            // 순간 이동 (*2)
            int np3 = cur.pos * 2;
            if(inRange(np3) && time[np3] > cur.time) {
                time[np3] = cur.time;
                pq.add(new Node(np3, time[np3]));
            }
        }
    }

    private static boolean inRange(int pos) {
        return (0 <= pos && pos <= MAX_POS);
    }
}

class Node implements Comparable<Node> {
    int pos;
    int time;

    public Node(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }

    // 시간 작은 순 정렬
    @Override
    public int compareTo(Node n) {
        return this.time - n.time;
    }
}
