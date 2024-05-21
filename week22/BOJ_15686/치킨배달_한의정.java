import java.util.*;
import java.io.*;

public class 치킨배달_한의정 {
    static int N, M;
    static int[][] map;

    static List<int[]> chickens = new ArrayList<>();    // 치킨집 위치 저장 리스트
    static List<int[]> houses = new ArrayList<>();      // 집 위치 저장 리스트
    static boolean[] selected;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {   // 집 위치 저장
                    houses.add(new int[]{i, j});
                } else if (map[i][j] == 2) {    // 치킨집 위치 저장
                    chickens.add(new int[]{i, j});
                }
            }
        }

        selected = new boolean[chickens.size()];
        combination(0, 0);
        System.out.println(min);
    }

    // 백트래킹
    private static void combination(int idx, int cnt) {
        if (cnt == M) { // 치킨 거리 최솟값 구하기
            min = Math.min(min, calcDist());
            return;
        }

        for (int i = idx ; i < chickens.size() ; i++) {
            if(!selected[i]) {
                selected[i] = true;
                combination(i + 1, cnt + 1);
                selected[i] = false;
            }
        }
    }

    // 집-치킨집 간 최소 거리 계산 메소드
    private static int calcDist() {
        int total = 0;  // 치킨 거리

        for (int[] h : houses) {
            int tmp = Integer.MAX_VALUE;

            // 어떤 집과 선택된 치킨집의 모든 거리 비교하고, 이 중 최소 거리 계산
            for (int i = 0; i < chickens.size(); i++) {
                if(selected[i]) {
                    int[] c = chickens.get(i);
                    int distance = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);

                    tmp = Math.min(tmp, distance);
                }
            }
            total += tmp;
        }

        return total;
    }
}