public class Solution {
    public long solution(int cap,int n,int[] deliveries,int[] pickups){
        int deliver = 0; //deliver은 한 집에 배달할 상자의 개수
        int pickup = 0; //pickup은 한 집에서 수거할 상자의 개수
        long answer = 0;

        for(int i = n-1; i >= 0; i--){
            deliver += deliveries[i];
            pickup += pickups[i];

            while(deliver > 0 || pickup > 0 ){//i번째 집에 배달하거나 수거해야할 상자가 있다면
                deliver -= cap;
                pickup -= cap;
                answer += (i+1)*2; //왕복거리
            }
        }

        return answer;
    }
}