import java.util.*;
import java.io.*;

public class 캠프준비_한의정 {
    static int N,L,R,X, answer;
    static int[] A;
    static boolean[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);	// 숫자들 오름차순 정렬해두기

        for(int i = 2 ; i <= N ; i++) {	// 문제 2~N개 뽑기
            chk = new boolean[N];
            dfs(0, i);
        }
        System.out.println(answer);
    }

    private static void dfs(int cnt, int target) {
        if(cnt == target) {
            List<Integer> list = new ArrayList<>();	// 뽑은 숫자 저장용 리스트
            int sum = 0;	// 뽑은 숫자들의 합

            for(int i = 0 ; i < N ; i++) {
                if(chk[i]) {	// 뽑은 숫자인 경우 > 리스트에 숫자를 저장하고, 숫자들의 합 갱신
                    list.add(A[i]);
                    sum += A[i];
                }
            }

            // L 이상 R 이하고, 리스트의 최대-최소 값이 X 이상인 경우 정답 갯수+1
            if(L <= sum && sum <= R && (list.get(list.size()-1) - list.get(0) >= X)) {
                answer++;
            }
            return;
        }

        for(int i = cnt ; i < N ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                dfs(i + 1, target);
                chk[i] = false;
            }
        }
    }
}
