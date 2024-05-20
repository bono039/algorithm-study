import java.util.*;
import java.io.*;

public class 꽃길_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N;
    static int[][] board;
    static boolean[][] visited;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int cnt, int sum) {
        // 꽃 3개 심었다면, 최소 비용 갱신
        if(cnt == 3) {
            answer = Math.min(answer, sum);
            return;
        }

        // 모든 화단 탐색
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                // (i,j)에 꽃을 심을 수 있는 경우
                if(isPossible(i,j)) {
                    int tmpSum = getSum(i, j);

                    // 꽃 심은 자리 & 상하좌우 방문처리
                    visited[i][j] = true;
                    for(int d = 0 ; d < 4 ; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        visited[nx][ny] = true;
                    }

                    dfs(cnt + 1, sum + tmpSum);

                    // 꽃 심은 자리 & 상하좌우 초기화
                    visited[i][j] = false;
                    for(int d = 0 ; d < 4 ; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        visited[nx][ny] = false;
                    }
                }
            }
        }
    }

    // x행 y열에 꽃을 심을 수 있는지 판별하는 메소드
    private static boolean isPossible(int x, int y) {
        if(visited[x][y])   return false;

        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N)  return false;
            if(visited[nx][ny]) return false;
        }

        return true;
    }

    // x행 y열에 꽃을 심었을 때의 비용 계산하는 메소드
    private static int getSum(int x, int y) {
        int sum = board[x][y];

        for(int d = 0 ; d < 4 ; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            sum += board[nx][ny];
        }

        return sum;
    }
}