import java.util.*;
import java.io.*;

public class 특정거리의도시찾기_한의정 {
    static int N,M,K,X;
    static List<Integer>[] list;    // 인접 리스트

    static Queue<Integer> q = new ArrayDeque<>();
    static int[] distance;  // X부터의 거리 정보 저장 겸 방문 표시 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 도시 개수
        M = Integer.parseInt(st.nextToken());   // 도로 정보
        K = Integer.parseInt(st.nextToken());   // 거리 정보
        X = Integer.parseInt(st.nextToken());   // 출발 도시 번호

        // 인접 리스트, 거리 배열 초기화
        list = new ArrayList[N + 1];
        distance = new int[N + 1];

        for(int i = 1 ; i <= N ; i++) {
            list[i] = new ArrayList<>();
            distance[i] = -1;   // 거리 배열 모두 -1로 초기화
        }

        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B); // 단방향 추가
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        boolean chk = false;
        for(int i = 1 ; i <= N ; i++) {
            if(distance[i] == K) {
                sb.append(i).append("\n");
                chk = true;
            }
        }
        System.out.println(chk ? sb : -1);
    }

    private static void bfs() {
        distance[X] = 0;    // 시작점 위치는 거리 0으로 설정
        q.add(X);

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : list[now]) { // 다음 정점 방문하기
                if(distance[next] == -1) {  // 해당 정점을 방문하지 않았다면, 방문하고 거리 업데이트
                    distance[next] = distance[now] + 1;
                    q.add(next);
                }
            }
        }
    }
}
