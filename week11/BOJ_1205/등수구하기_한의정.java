import java.util.*;
import java.io.*;

public class 등수구하기_한의정 {
    static int N, tsScore, P;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        tsScore = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        if(N == 0) {
            System.out.println(1);
            return;
        }

        A = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        if(N == P && tsScore <= A[A.length - 1]) {  // 리스트가 꽉 찼고, 태수의 새로운 점수가 최하위 점수보다 작거나 같다면 못 끼므로 -1 출력
            answer = -1;
        }
        else {  // 그게 아니라면, 랭킹 구하기
            int rank = 1;

            for(int i = 0 ; i < N ; i++) {
                if(tsScore < A[i])
                    rank++;
                else
                    break;
            }

            answer = rank;
        }

        System.out.println(answer);
    }
}
