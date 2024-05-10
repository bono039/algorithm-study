import java.util.*;
import java.io.*;

public class 상어중학교_한의정 {
    static int BLACK = -1, RAINBOW = 99, EMPTY = 0;
    static int N, M, sum;
    static int[][] map;
    static int[] dx = { -1, 0, 1, 0 }, dy = { 0, 1, 0, -1 };    // 상 우 하 좌
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        init();
        solution();
        System.out.println(sum);
    }

    static void solution() {
        while (true) {
            // 1. 크기가 가장 큰 블록 그룹을 찾는다.
            Block standardBlock = findMaxBlockGroupe();
            if (standardBlock == null) return;

            sum += standardBlock.sum * standardBlock.sum;   // 점수 합산

            // 2. 1에서 찾은 블록 그룹의 모든 블록 제거
            removeBlock(standardBlock);

            // 3. 중력 작용
            applyGravity();

            // 4. 반시계 방향 90도 회전
            rotateMap();

            // 5. 다시 중력 작용
            applyGravity();
        }
    }

    // 크기가 가장 큰 블록 그룹 찾는 메소드
    static Block findMaxBlockGroupe() {
        visited = new boolean[N][N];
        Block maxBlock = new Block(0, 0, EMPTY, Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == BLACK || map[i][j] == RAINBOW || map[i][j] == EMPTY)   continue;

                // bfs 탐색 전 무지개 블록만 방문 처리 초기화
                initRainBowVisited();

                Block cur = bfsBlock(i, j, map[i][j]);

                // 그룹 블록 수 2개보다 작으면 skip
                if (cur == null)    continue;

                // 최대 블록 수 갱신
                if (maxBlock.compareBlock(cur)) {
                    maxBlock = cur;
                }
            }
        }

        if (maxBlock.color == EMPTY)    // 블록 그룹 못 찾은 경우
            return null;
        return maxBlock;
    }

    // 무지개 블록만 방문 처리 초기화하는 메소드
    static void initRainBowVisited() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == RAINBOW)
                    visited[i][j] = false;
            }
        }
    }

    // bfs로 같은 색 블록 탐색
    static Block bfsBlock(int x, int y, int color) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});

        visited[x][y] = true;

        int sum = 1;
        int rainbowSum = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (!inRange(nx, ny) || visited[nx][ny])    continue;
                if (map[nx][ny] == BLACK || map[nx][ny] == EMPTY)   continue;

                // color 다른 무지개 블록일 때만 넣기
                if (map[nx][ny] != color) {
                    if (map[nx][ny] == RAINBOW) {
                        rainbowSum++;
                        sum++;

                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                    continue;
                }

                sum++;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        if (sum < 2)    // 그룹에 속한 블록 수가 2개 미만이면 null
            return null;
        return new Block(x, y, color, sum, rainbowSum);
    }

    static boolean inRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

    // 기준 블록과 같은 그룹 모두 제거
    static void removeBlock(Block block) {
        visited = new boolean[N][N];
        visited[block.x][block.y] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {block.x, block.y});

        map[block.x][block.y] = EMPTY;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (!inRange(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == BLACK || map[nx][ny] == EMPTY) continue;

                // color 다른 무지개 블록일 때만 넣기
                if (map[nx][ny] != block.color) {
                    if (map[nx][ny] == RAINBOW) {
                        visited[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                        map[nx][ny] = EMPTY;
                    }
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new int[] {nx, ny});
                map[nx][ny] = EMPTY;
            }
        }
    }

    // 중력 작용 메소드
    static void applyGravity() {
        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (map[j][i] == BLACK || map[j][i] == EMPTY) {
                    continue;
                }

                moveBlock(j, i);
            }
        }
    }

    // 블록 한 개씩 옮기는 메소드
    static void moveBlock(int x, int y) {
        int cx = x;

        while (true) {
            cx++;
            if (cx >= N) {
                break;
            }
            if (map[cx][y] == BLACK || map[cx][y] != EMPTY) {
                break;
            }
        }
        cx--;

        if (cx == x)    return; // 안 움직인 경우

        map[cx][y] = map[x][y];
        map[x][y] = EMPTY;
    }

    // 반시계 90도 방향 회전 메소드
    static void rotateMap() {
        int[][] map_copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map_copy[i][j] = map[j][N - 1 - i];
            }
        }

        map = map_copy;
    }

    static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = 0;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == -1)    map[i][j] = BLACK;
                else if (map[i][j] == 0)    map[i][j] = RAINBOW;
            }
        }
    }

    static class Block {
        int x, y, color, sum, rainbowSum;

        public Block(int x, int y, int color, int sum, int rainbowSum) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.sum = sum;                 // 블록 그룹의 총 블록 수
            this.rainbowSum = rainbowSum;   // 블록 그룹에 속한 무지개 블록 수
        }

        public boolean compareBlock(Block other) {  // 나보다 other이 크면 true
            if (this.sum != other.sum)  // 블록 수로 비교
                return this.sum < other.sum;

            if (this.rainbowSum != other.rainbowSum)    // 무지개 블록 수로 비교
                return this.rainbowSum < other.rainbowSum;

            if (this.x != other.x)  // 행으로 비교
                return this.x < other.x;

            return this.y < other.y;    // 열로 비교
        }
    }
}