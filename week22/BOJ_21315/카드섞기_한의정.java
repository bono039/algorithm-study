import java.util.*;
import java.io.*;

public class 카드섞기_한의정 {
    static int N;
    static int[] arr;
    static LinkedList<Integer> list;	// 변형된 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1 ; Math.pow(2, i) < N ; i++) {
            for(int j = 1 ; Math.pow(2, j) < N ; j++) {
                // 리스트에 1부터 N까지 숫자 추가하기
                list = new LinkedList<>();
                for(int x = 1 ; x <= N ; x++) {
                    list.add(x);
                }

                shuffle(i);	// i번 섞기
                shuffle(j);	// j번 섞기

                // 섞인 리스트가 주어진 배열과 같은지 확인
                if(chk()) {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }

    // 리스트가 주어진 배열과 같은지 확인하는 함수
    private static boolean chk() {
        for(int i = 0 ; i < N ; i++) {
            if(arr[i] != list.get(i))
                return false;
        }
        return true;
    }

    // 리스트 섞는 함수
    private static void shuffle(int k) {
        int x = 1;	// 시작 인덱스

        // k번 반복
        while(k - x + 1 >= 0) {
            int cnt = (int)Math.pow(2, k-x+1);	// 2ㅇㅢ k-x+1 승

            // cnt번 반복
            for(int j = 0 ; j < cnt ; j++) {
                if(x == 1)	// 리스트의 마지막 요소를 첫 번째로 이동
                    list.addFirst(list.removeLast());
                else	// 2의 k-x+2 승 - 1 위치의 요소를 첫 번째로 이동
                    list.addFirst(list.remove((int)Math.pow(2, k-x+2) -1));
            }

            x++;	// 인덱스 증가
        }
    }
}
