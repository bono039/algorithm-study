import java.util.*;
import java.io.*;

public class 모래성_한의정 {
    static int[] dr = {-1,1,0,0,-1,-1,1,1};
    static int[] dc = {0,0,-1,1,-1,1,-1,1};

    static int H,W;
    static char[][] board;
    static Queue<int[]> q = new ArrayDeque<>(); // 모래성이 "없는" 위치 저장 리스트
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        board = new char[H][W];

        for(int i = 0 ; i < H ; i++) {
            String str = br.readLine();
            for(int j = 0 ; j < W ; j++) {
                board[i][j] = str.charAt(j);

                if(board[i][j] == '.') {    // 모래성이 "없는" 위치 저장!!
                    q.add(new int[] {i, j});
                }
            }
        }

        bfs();
        System.out.println(answer - 1);
    }

    private static void bfs() {
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0 ; i < size ; i++) {    // 큐 사이즈만큼 반복하게
                int[] now = q.poll();

                for(int d = 0 ; d < 8 ; d++) {  // 모래성이 "없는" 노드의 주변 8방향 탐색
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];

                    if(nr >= 0 && nr < H && nc >= 0 && nc < W) {
                        if(board[nr][nc] != '.') {  // 모래성이라면, 튼튼함 1 깎기
                            board[nr][nc]--;

                            if(board[nr][nc] == '0') {  // 새로 모래성이 없어진 노드만 큐에 추가
                                board[nr][nc] = '.';
                                q.add(new int[] {nr, nc});
                            }
                        }
                    }
                }
            }

            answer++;
        }
    }
}