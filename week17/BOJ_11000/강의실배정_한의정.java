import java.util.*;
import java.io.*;

public class 강의실배정_한의정 {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 시작 시간이 같다면, 종료 시간 기준 오름차순 정렬하고
        // 시작 시간이 다르다면, 시작 시간 기준 오름차순 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])  return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();  // 종료 시간 기준 오름차순 정렬하기 위한 우선순위 큐
        pq.add(arr[0][1]);

        for(int i = 1 ; i < N ; i++) {
            // 가장 빨리 끝나는 강의의 종료 시간 vs 배정 안 된 강의의 시작 시간
            if(pq.peek() <= arr[i][0])
                pq.poll();

            // 배정이 안 된 강의를 우선순위 큐에 넣음
            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());  // 우선순위 큐 크기 = 필요한 강의실 수
    }
}
