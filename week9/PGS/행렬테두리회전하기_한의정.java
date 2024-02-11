import java.util.*;

class 행렬테두리회전하기_한의정 {
    static int[] dx = {1, 0, -1, 0};    // 시계 방향 회전 (동남서북)
    static int[] dy = {0, 1, 0, -1};

    static int rows, columns;
    static int[][] queries, arr;
    static int min;

    public int[] solution(int rows, int columns, int[][] queries) {
        this.rows = rows;
        this.columns = columns;
        this.queries = queries;

        int[] answer = new int[queries.length];

        // 배열 초기화
        arr = new int[rows][columns];
        int val = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = val++;
            }
        }

        // 각 쿼리에 대해 시뮬레이션 수행
        for (int i = 0; i < queries.length; i++) {
            min = Integer.MAX_VALUE;
            answer[i] = simulate(queries[i]);
        }

        return answer;
    }

    // 시계방향으로 행렬을 회전하고, 회전 후의 최솟값 반환
    private static int simulate(int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;

        int tmp = arr[x1][y1];
        int dir = 0;    // 시작 방향

        int x = x1;
        int y = y1;

        // 4방향으로 시계방향으로 회전
        while (dir < 4) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 지정 범위를 벗어나면, 회전 방향 변경
            if (nx < x1 || ny < y1 || nx > x2 || ny > y2) {
                dir++;
            }
            else {    // 범위 안에 있으면 정상 이동
                arr[x][y] = arr[nx][ny];
                x = nx;
                y = ny;

                min = Math.min(min, arr[x][y]);  // 가져올 최솟값 갱신
            }
        }

        arr[x][y + 1] = tmp;
        min = Math.min(min, arr[x][y + 1]);

        return min;
    }
}
