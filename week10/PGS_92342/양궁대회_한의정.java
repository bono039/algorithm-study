import java.util.*;

class 양궁대회_한의정 {
    static int n;
    static int[] info;

    static int[] lion = {-1};           // 정답 배열
    static int[] arrows = new int[11];  // 점수 차가 최대일 때 라이언이 쏜 화살 정보 저장용 배열

    static int max = Integer.MIN_VALUE; // 최댓값

    public int[] solution(int n, int[] info) {
        this.n = n;
        this.info = info;

        dfs(0);

        if(max == -1) { // 어피치가 이기는 경우
            lion = new int[]{-1};
        }
        return lion;
    }

    // 라이언이 쏜 화살에 대한 조합 구하는 메서드
    private static void dfs(int depth) {
        if(depth == n) {
            int diff = getScore();  // 점수 차 구하기

            if(max <= diff) {   // 점수 차 최댓값 갱신
                max = diff;
                lion = arrows.clone();  // 화살 정보를 정답 배열로 복사
            }
            return;
        }

        for(int i = 0 ; i < info.length && arrows[i] <= info[i] ; i++) {    // 가지치기 조건 필수!! (안 하면 시간초과)
            arrows[i]++;
            dfs(depth + 1);
            arrows[i]--;
        }
    }

    // 점수 차 계산 메서드
    private static int getScore() {
        int apeach = 0;
        int lion = 0;

        for(int i = 0 ; i <= 10 ; i++) {
            if(info[i] == 0 && arrows[i] == 0)  continue;   // 어피치, 라이언 둘 다 0 맞추면 무시

            if(info[i] >= arrows[i])
                apeach += (10 - i);
            else
                lion += (10 - i);
        }

        int diff = lion - apeach;

        if(diff <= 0)
            return -1;
        return diff;
    }
}