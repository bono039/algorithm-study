public class 택배배달과수거하기_한의정 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0;  // 배달해야 하는 택배
        int p = 0;  // 수거해야 하는 택배

        for(int i = n - 1 ; i >= 0 ; i--) { // 제일 먼 거릴부터 배달과 수거
            d -= deliveries[i];
            p -= pickups[i];

            while(d < 0 || p < 0) { // 배달 가능한 택배 용량이 초과된 경우, 다시 방문
                d += cap;
                p += cap;
                answer += (i + 1) * 2;  // 왕복거리 더하기
            }
        }

        return answer;
    }
}
