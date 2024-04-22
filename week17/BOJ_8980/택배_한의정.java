import java.util.*;
import java.io.*;

public class 택배_한의정 {
    static int N,C,M;
    static Info[] info;
    static int[] capacities;    // 마을 별로 받는 박스 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());   // 마을 수
        C = Integer.parseInt(st.nextToken());   // 트럭 용량

        M = Integer.parseInt(br.readLine());    // 보내는 박스 정보 개수

        // 보내는 박스 정보 입력 후 정렬하기
        info = new Info[M + 1];
        for(int i = 1 ; i <= M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());

            info[i] = new Info(from, to, box);
        }
        Arrays.sort(info, 1, M+1);

        // 마을들이 받을 수 있는 택배 용량을 C만큼으로 설정해 두기
        capacities = new int[N + 1];
        for(int i = 1 ; i < N ; i++) {
            capacities[i] = C;
        }

        int answer = 0;

        for(int i = 1 ; i <= M ; i++) {
            Info now = info[i];

            // 1. 보낼 수 있는 최대 한도만큼 박스 싣기
            int maxCapacity = Integer.MAX_VALUE;
            for(int j = now.from ; j < now.to ; j++) {
                maxCapacity = Math.min(maxCapacity, capacities[j]);
            }

            // 2. 실어준 박스의 목표 마을 전까지 용량 줄이기
            for(int j = now.from ; j < now.to ; j++) {
                capacities[j] -= Math.min(maxCapacity, now.box);
            }

            answer += Math.min(maxCapacity, now.box);
        }

        System.out.println(answer);
    }
}

class Info implements Comparable<Info> {
    int from, to, box;

    public Info(int from, int to, int box) {
        this.from = from;
        this.to = to;
        this.box = box;
    }

    @Override
    public int compareTo(Info i) {
        if(this.to == i.to)
            return this.from - i.from;
        return this.to - i.to;
    }
}