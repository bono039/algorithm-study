import java.util.*;
import java.io.*;

public class 도영이가만든맛있는음식_한의정 {
    static int N, S, B;
    static int[][] arr;

    static List<Integer> list = new ArrayList<>();  // 뽑은 재료 리스트
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());    // 재료 개수
        arr = new int[N][2];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());   // 신맛 : 곱
            arr[i][1] = Integer.parseInt(st.nextToken());   // 쓴맛 : 합
        }

        // 1~N개 재료 고르기
        for(int i = 1 ; i <= N ; i++) {
            dfs(0, 0, i, 1, 0);
        }

        System.out.println(min);
    }

    // [백트래킹] (재료 idx, 지금까지 뽑은 재료 수, 뽑아야 하는 재료 수, 신맛, 쓴맛)
    private static void dfs(int idx, int cnt, int target, int sour, int bitter) {
        // 원하는 갯수만큼 뽑았을 때 신맛과 쓴맛의 차이 구해 최솟값과 갱신
        if(cnt == target) {
            min = Math.min(min, Math.abs(sour - bitter));
            return;
        }

        for(int i = idx ; i < N ; i++) {
            list.add(i);
            dfs(i + 1, cnt + 1, target, sour * arr[i][0], bitter + arr[i][1]);  // 신맛과 쓴맛은 누적해 저장
            list.remove(list.size() - 1);
        }
    }
}
