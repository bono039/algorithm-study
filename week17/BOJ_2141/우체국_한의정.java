import java.util.*;
import java.io.*;

public class 우체국_한의정 {
    static int N;
    static Node[] arr;
    static long sum = 0; // 총 인구 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new Node[N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long X = Long.parseLong(st.nextToken());
            long A = Long.parseLong(st.nextToken());
            arr[i] = new Node(X, A);
            sum += A;
        }

        Arrays.sort(arr);

        long answer = 0;

        for(Node now : arr) {   // 하나씩 인구 수 계산
            answer += now.a;

            if(answer >= (sum + 1) / 2) {   // 중간값과 가장 근접한 마을 찾기
                System.out.println(String.valueOf(now.x));
                break;
            }
        }
    }
}

class Node implements Comparable<Node> {
    long x, a;

    public Node(long x, long a) {
        this.x = x;
        this.a = a;
    }

    @Override
    public int compareTo(Node n) {
        if(this.x == n.x)   return (int)(this.a - n.a); // 서로 거리가 같은 경우, 마을 인원 수 기준 오름차순 정렬
        return (int)(this.x - n.x); // 서로 거리가 다르다면, 거리 기준 오름차순 정렬
    }
}
