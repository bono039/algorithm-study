import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int test = sc.nextInt(); //테스트 케이스

        for(int i = 0; i < test; i++){
            int num = sc.nextInt(); //원소의 개수
            int doc = sc.nextInt(); //문서의 doc번째 원소의 출력 순서를 알고싶다
            int ans = printQueue(num,doc);
            System.out.println(ans);
        }
    }

    static int printQueue(int num,int doc){//문서의 doc번째 원소의 출력 순서를 알려주는 메서드
        Queue<Integer> queue = new LinkedList<>(); //프린터큐
        Queue<Integer> docQueue = new LinkedList<>(); //문서의 순서인 0~num까지 있는 큐
        int[] arr = new int[num];// 프린터큐에 들어있는 문서들의 중요도를 정렬하기 위한 배열
        Queue<Integer> answerQueue = new LinkedList<>();//중요도가 가장큰 문서를 찾았을때 poll하고 그 값을 answer큐에 넣는다

        for(int i = 0; i < num; i++){
            int importance = sc.nextInt();
            queue.add(importance); //프린터큐에 입력
            docQueue.add(i);// docQueue에는 문서의 순서(0~num-1)를 적는다
            arr[i] = importance; //정렬하기 위해 배열에 수를 넣는다
        }

        Arrays.sort(arr); //배열 정렬
        int i = num - 1; //중요도가 가장큰 수는 배열의 맨 끝자리에 있으므로 i = num-1

        while(true){
            if(arr[i] == queue.peek()){//가장 큰 중요도를 가진 문서와 현재 프린터큐에 들어가있는 수를 비교한다
                answerQueue.add(queue.poll());//현재 프린터큐의 맨앞의 수가 arr[i]와 같다면 프린터큐에서 poll한 수를 answerqueue에 넣음
                int docQueuePop = docQueue.poll();
                i--;

                if(docQueuePop == doc)return answerQueue.size();
            }else{
                int queuePop = queue.poll();
                int docQueuePop = docQueue.poll();

                queue.add(queuePop);
                docQueue.add(docQueuePop);
            }
        }


    }
}
