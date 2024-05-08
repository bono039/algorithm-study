package BOJ_5014;

import java.util.*;
import java.io.*;

public class 스타트링크_한의정 {
    static int F,S,G,U,D;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());   // 건물 총 층
        S = Integer.parseInt(st.nextToken());   // 강호 층
        G = Integer.parseInt(st.nextToken());   // 회사 층 (=목표 층)
        U = Integer.parseInt(st.nextToken());   // 위
        D = Integer.parseInt(st.nextToken());   // 아래

        arr = new int[F + 1];
        int answer = bfs();

        System.out.println(answer == -1 ? "use the stairs" : answer);
    }

    private static int bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(S);

        arr[S] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(now == G) {  // 목표 층 G층 도착 시
                return arr[now] - 1;
            }

            if(now + U <= F) {  // 최고층 F층 아래에 있고
                if(arr[now + U] == 0) { // 방문한 적 없는 경우
                    arr[now + U] = arr[now] + 1;
                    q.add(now + U);
                }
            }
            if(now - D >= 1) {  // 최저층 1층 이상에 있고
                if(arr[now - D] == 0) { // 방문한 적 없는 경우
                    arr[now - D] = arr[now] + 1;
                    q.add(now - D);
                }
            }
        }

        return -1;  // 목표 층 도착 못 할 시 -1 출력
    }
}
