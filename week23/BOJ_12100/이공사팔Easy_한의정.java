import java.util.*;
import java.io.*;

public class 이공사팔Easy_한의정 {
    static int N;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int cnt) {
        if(cnt == 5) {  // 명령 5번 수행 후 종료
            findMax();
            return;
        }

        // 배열 복사
        int[][] copy = copyArray(map);

        // 이동 방향 정하기
        for(int d = 0 ; d < 4 ; d++) {
            move(d);
            dfs(cnt + 1);

            map = copyArray(copy);  // 배열 값 원상복구
        }
    }

    // 배열 복사하는 함수
    private static int[][] copyArray(int[][] arr) {
        int[][] tmp = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }

    // 해당 방향으로 이동하는 함수 (0:상 / 1:하 / 2:좌 / 3:우)
    private static void move(int dir) {
        switch(dir) {
            // [상]
            case 0:
                for(int i = 0 ; i < N ; i++) {  // 열
                    int idx = 0;    // 값 넣을 위치
                    int block = 0;  // 최근 블록의 값

                    for(int j = 0 ; j < N ; j++) {  // 행
                        if(map[j][i] != 0) {    // 현재 블록 값이 0이 아닌 경우
                            if(block == map[j][i]) {            // 최근 블록 값이 현재 블록 값과 "같다면"
                                map[idx - 1][i] = block * 2;    // 블록 합치기
                                block = 0;                      // 블록 합쳐졌으므로 0으로 갱신
                                map[j][i] = 0;                  // 값 합쳤으므로 현재 블록 값을 0으로 갱신
                            }
                            else {
                                block = map[j][i];              // 블록 변수 값을 현재 블록 값으로 갱신
                                map[j][i] = 0;                  // 현재 블록 값 0으로 바꿈
                                map[idx][i] = block;            // 값 넣을 위치에 최근 블록 값 넣기
                                idx++;
                            }
                        }
                    }
                }
                break;

            // [하]
            case 1:
                for(int i = 0 ; i < N ; i++) {  // 열
                    int idx = N-1;  // 값 넣을 위치
                    int block = 0;  // 최근 블록의 값

                    for(int j = N-1 ; j >= 0 ; j--) {   // 행
                        if(map[j][i] != 0) {
                            if(block == map[j][i]) {
                                map[idx + 1][i] = block * 2;
                                block = 0;
                                map[j][i] = 0;
                            }
                            else {
                                block = map[j][i];
                                map[j][i] = 0;
                                map[idx][i] = block;
                                idx--;
                            }
                        }
                    }
                }
                break;

            // [좌]
            case 2:
                for(int i = 0 ; i < N ; i++) {  // 행
                    int idx = 0;    // 값 넣을 위치
                    int block = 0;  // 최근 블록의 값

                    for(int j = 0 ; j < N ; j++) {  // 열
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][idx - 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = block;
                                idx++;
                            }
                        }
                    }
                }
                break;

            // [우]
            case 3:
                for(int i = 0 ; i < N ; i++) {  // 행
                    int idx = N-1;  // 값 넣을 위치
                    int block = 0;  // 최근 블록의 값

                    for(int j = N-1 ; j >= 0 ; j--) {   // 열
                        if(map[i][j] != 0) {
                            if(block == map[i][j]) {
                                map[i][idx + 1] = block * 2;
                                block = 0;
                                map[i][j] = 0;
                            }
                            else {
                                block = map[i][j];
                                map[i][j] = 0;
                                map[i][idx] = block;
                                idx--;
                            }
                        }
                    }
                }
                break;
        }
    }

    // 최댓값 찾는 함수
    private static void findMax() {
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
    }
}
