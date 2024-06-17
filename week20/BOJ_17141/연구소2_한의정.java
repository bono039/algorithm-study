package BOJ_17141;

import java.util.*;
import java.io.*;

public class 연구소2_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N,M;
    static int[][] lab;
    static List<int[]> vList =  new ArrayList<>();  // 바이러스 위치 저장 리스트
    static boolean[] chk;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab =  new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 2) {    // 바이러스 위치 저장
                    vList.add(new int[] {i,j});
                }
            }
        }

        chk = new boolean[vList.size()];
        dfs(0, 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int idx, int cnt) {
        if(cnt == M) {  // 바이러스 심을 위치 M개 뽑기
            bfs();
            return;
        }

        for(int i = idx ; i < vList.size() ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                dfs(i + 1, cnt + 1);
                chk[i] = false;
            }
        }
    }

    private static void bfs() {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        // 배열 복사하기
        int[][] copy = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                copy[i][j] = lab[i][j];
            }
        }

        // 뽑힌 바이러스들 > 큐에 추가하고, 방문 처리하고, 값 0으로 바꾸기
        for(int i = 0 ; i < chk.length ; i++) {
            if(chk[i]) {
                int x = vList.get(i)[0];
                int y = vList.get(i)[1];
                q.add(new int[]{x,y});
                visited[x][y] = true;
                copy[x][y] = 0;
            }
        }

        int time = 0; // 퍼뜨린 시간

        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N)  continue;   // 격자 범위 벗어나는 경우
                if(copy[nx][ny] == 1 && lab[nx][ny] == 1)   continue;   // 벽인 경우
                if(visited[nx][ny]) continue;   // 방문한 적 있는 경우

                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
                copy[nx][ny] = copy[now[0]][now[1]] + 1;    // 바이러스 퍼뜨리는 시간 갱신
                time = Math.max(time, copy[nx][ny]);
            }
        }

        // 모든 빈 칸에 바이러스 퍼뜨렸는지 확인
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                if(copy[i][j] == 0 && lab[i][j] == 0)
                    return;
                if(copy[i][j] == 2 && !visited[i][j])
                    return;
            }
        }

        // 모든 빈 칸에 바이러스 있는 최소 시간 갱신
        answer = Math.min(answer, time);
    }
}
