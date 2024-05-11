package BOJ_17142;

import java.util.*;
import java.io.*;

public class 연구소3_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N,M;
    static int[][] lab;

    static List<Virus> vList = new ArrayList<>();
    static boolean[] chk;

    static int zeroCnt = 0; // 초기 빈 칸 개수
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());

                if(lab[i][j] == 0)  // 빈 칸 개수 + 1
                    zeroCnt++;
                else if(lab[i][j] == 2)
                    vList.add(new Virus(i, j, 0));
            }
        }

        if(zeroCnt == 0) {  // 이 처리 안 하면 91%에서 틀림
            System.out.println(0);
            return;
        }

        chk = new boolean[vList.size()];
        dfs(0,0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    // M개 바이러스 선택하는 메소드 (조합)
    private static void dfs(int idx, int depth) {
        if(depth == M) {
            bfs(zeroCnt);
            return;
        }

        for(int i = idx ; i < vList.size() ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                dfs(i + 1, depth + 1);
                chk[i] = false;
            }
        }
    }

    // 바이러스 퍼뜨리는 메소드 (BFS)
    private static void bfs(int emptyCnt) {
        Queue<Virus> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];

        for(int i = 0 ; i < chk.length ; i++) {
            if(chk[i]) {
                int x = vList.get(i).x;
                int y = vList.get(i).y;
                visited[x][y] = true;
                q.add(new Virus(x, y, 0));
            }
        }

        while(!q.isEmpty()) {
            Virus now = q.poll();

            for(int d = 0 ; d < 4 ; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                // [pass] 격자 범위 벗어나거나 / 방문한 적 있거나 / 벽인 경우
                if(nx < 0 || nx >= N || ny < 0 || ny >= N)  continue;
                if(visited[nx][ny] || lab[nx][ny] == 1) continue;

                if(lab[nx][ny] == 0) {  // 다음 칸이 빈 칸이면, 방문하러 갈 거니까 빈 칸 개수 줄이기
                    emptyCnt--;
                }

                if(emptyCnt == 0) { // 빈 칸 갯수가 0개면, 정답 갱신
                    answer = Math.min(answer, now.time + 1);
                    return;
                }

                // 다음 칸 방문 > 방문 처리하고, 시간 + 1해서 큐에 추가
                visited[nx][ny] = true;
                q.add(new Virus(nx, ny, now.time + 1));
            }
        }
    }
}

class Virus {
    int x,y,time;

    public Virus(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
