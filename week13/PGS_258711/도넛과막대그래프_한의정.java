import java.util.*;

class 도넛과막대그래프_한의정 {
    static final int MAX = 1_000_000;

    static int[][] edges;
    static int[] input, output;

    public int[] solution(int[][] edges) {
        this.edges = edges;

        input = new int[MAX + 1];   // 받은 것 (진입)
        output = new int[MAX + 1];  // 준 것 (진출)

        int maxNode = 0;
        for(int[] e : edges) {
            input[e[1]]++;
            output[e[0]]++;

            maxNode = Math.max(maxNode, Math.max(e[0], e[1]));
        }

        int[] answer = new int[4];

        for(int i = 1 ; i <= maxNode ; i++) {
            if(input[i] == 0 && output[i] >= 2) {   // [생성된 정점]
                answer[0] = i;
            }
            else if(input[i] > 0 && output[i] == 0) {   // [막대 모양] 최상위 노드에서 다른 노드로 향하는 간선이 없는 경우
                answer[2]++;
            }
            else if(input[i] >= 2 && output[i] >= 2) {  // [8자 모양] 들어오는 간선이 2개 이상, 나가는 간선이 2개인 경우
                answer[3]++;
            }
        }

        // [도넛 모양] 생성된 정점으로부터 파생된 그래프 수 - (막대 모양 그래프 수 + 8자 모양 그래프 수)
        answer[1] = output[answer[0]] - (answer[2] + answer[3]);

        return answer;
    }
}