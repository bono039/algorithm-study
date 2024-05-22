import java.util.*;
import java.io.*;

public class NxM보드완주하기_한의정 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int N,M;
    static char[][] map;
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int idx = 0;
        String input = "";

        while((input = br.readLine()) != null) {
            idx++;
            answer = -1;

            st = new StringTokenizer(input);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            visited = new boolean[N][M];

            int result = 1; // 이동 횟수
            int cnt = 1; // 방문 개수

            for(int i = 0 ; i < N ; i++) {
                String str = br.readLine();
                for(int j = 0 ; j < M ; j++) {
                    map[i][j] = str.charAt(j);

                    if(map[i][j] == '*') { // 장애물인 경우, 미리 방문 처리
                        visited[i][j] = true;
                        cnt++;
                    }
                }
            }

            // 한 칸만 빈 칸인 경우
            if(cnt == N*M)  answer = 0;

            for(int i = 0 ; i < N ; i++) {
                for(int j = 0 ; j < M ; j++) {
                    if(visited[i][j])   continue; // 장애물인 경우, pass

                    for(int d = 0 ; d < 4 ; d++) { // 빈 칸(.)인 경우, 4방향 탐색
                        if(!isValid(i + dx[d], j + dy[d])) continue;

                        visited[i][j] = true;
                        search(i, j, result, d, cnt);
                        visited[i][j] = false; // 지나온 길 되돌아가기
                    }
                }
            }

            System.out.println("Case " + idx + ": " + answer);
        }
    }

    //                          x좌표, y좌표, 이동 횟수, 방향 번호, 방문한 칸 개수
    private static void search(int i, int j, int result, int dir, int cnt) {
        // [종료 조건] 모든 빈 칸을 방문한 경우
        if(cnt == N*M) {
            if(answer == -1 || answer > result) {
                answer = result;
                return;
            }
        }

        // 현재 방향으로 다음 칸 이동
        int x = i + dx[dir];
        int y = j + dy[dir];

        if(isValid(x, y)) {
            visited[x][y] = true;
            search(x, y, result, dir, cnt + 1); // 방문한 칸 갯수만 1 증가
            visited[x][y] = false; // 지나온 길 되돌아가기
        }
        else {  // 방향 변경
            for(int d = 0 ; d < 4 ; d++) {
                if(d == dir) continue;

                int nx = i + dx[d];
                int ny = j + dy[d];

                if(isValid(nx, ny)) {
                    visited[nx][ny] = true;
                    search(nx, ny, result + 1, d, cnt + 1); // 방향튼 횟수와 방문한 칸 갯수 모두 1 증가
                    visited[nx][ny] = false; // 지나온 길 되돌아가기
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        if(x < 0 || x >= N || y < 0 || y >= M)  // 보드 범위를 벗어난 경우
            return false;
        if(visited[x][y])   // 이미 방문한 칸인 경우
            return false;
        return true;
    }
}