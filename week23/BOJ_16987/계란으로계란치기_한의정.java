import java.util.*;
import java.io.*;

public class 계란으로계란치기_한의정 {
    static int N, answer;
    static int[] S,W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        S = new int[N]; // 계란 내구도
        W = new int[N]; // 계란 무게

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            S[i] = Integer.parseInt(st.nextToken());
            W[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);  // 0번째 계란부터 시작, 깨진 계란 수
        System.out.println(answer); // 깰 수 있는 최대 몇 개의 계란
    }

    private static void dfs(int depth, int cnt) {   // cnt: 깨진 계란 수
        // 마지막 계란까지 다 들었으면 종료
        if(depth == N) {
            answer = Math.max(answer, cnt);
            return;
        }

        // 손으로 든 계란이 이미 깨졌거나, 모든 계란이 이미 다 꺠진 경우 > 다음 계란 들기
        if(S[depth] <= 0 || cnt == N-1) {
            dfs(depth + 1, cnt);
            return;
        }

        int tmpCnt = cnt;   // 깨진 계란 수 원상복구 시 저장용

        for(int i = 0 ; i < N ; i++) {
            // 손으로 들고 있는 계란 = 부딪히려고 하는 계란인 경우, 계란이 이미 깨져있는 경우 통과
            if(i == depth || S[i] <= 0) continue;

            // 계란 부딪히기
            S[i] -= W[depth];
            S[depth] -= W[i];

            if(S[depth] <= 0)   cnt++;  // 손에 든 계란이 깨지면 +1
            if(S[i] <= 0)       cnt++;  // 타겟이 된 계란이 깨지면 +1

            dfs(depth + 1, cnt);    // 다음 계란 들기

            // 원상복구
            S[i] += W[depth];
            S[depth] += W[i];
            cnt = tmpCnt;
        }
    }
}
