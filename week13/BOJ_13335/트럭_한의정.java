import java.util.*;
import java.io.*;

public class 트럭_한의정 {
    static int n,w,L;
    static Queue<Integer> trucks = new LinkedList<>();  // 트럭 무게 저장용 큐
    static Queue<Integer> bridge = new LinkedList<>();  // 다리 위에 있는 트럭 저장용 큐
    static int time = 0;
    static int sum = 0;    // 다리 위 트럭들의 무게의 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        // 다리 길이만큼 0 저장해두기
        for(int i = 0 ; i < w;  i++) bridge.add(0);

        while(!bridge.isEmpty()) {  // 다리 위가 빌 때까지 반복문 수행
            time++;
            sum -= bridge.poll();

            if(!trucks.isEmpty()) {
                if(trucks.peek() + sum <= L) {  // 다리 위에 트럭 올리기
                    sum += trucks.peek();
                    bridge.add(trucks.poll());
                }
                else {  // 최대 무게 초과 시, 다리 위에 안 올림
                    bridge.add(0);
                }
            }
        }

        System.out.println(time);
    }
}
