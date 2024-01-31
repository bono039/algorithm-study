import java.util.*;

public class Solution {
    public static int solution(int[] queue1, int[] queue2) {
        int ans = 0; //총 몇 번 작업을 수행해야 하는지

        long total=0;//두큐의합
        long queue1Sum=0;//1번큐의합
        Queue<Integer> q1 = new LinkedList<Integer>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        for(int i=0; i<queue1.length; i++) {
            total += queue1[i]+queue2[i];
            q1Sum += q1[i];
            q1.add(queue1[i]); //두 큐에 수를 추가해준다
            q2.add(queue2[i]);
        }
        if(total%2!=0) return -1;//만약 두큐의합이 홀수면 같게 못만들어 -1을 return 한다

        long target = total/2;
        while(true) {
            if(ans>(queue1.length+queue2.length)*2) return -1;//이땐 더 순회해도 못만든다
            if(queue1Sum==target) break;
            else if(queue1Sum>target) {
                queue1Sum-=q1.peek();
                q2.add(q1.poll());
            }else {
                queue1Sum += q2.peek();
                q1.add(q2.poll());
            }
            ans++;
        }

        return ans;
    }
}