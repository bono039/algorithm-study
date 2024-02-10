import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] ingredient;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ingredient = new int[n][2];
        for(int i = 0; i < n; i++){//입력
            st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());//sour
            ingredient[i][1] = Integer.parseInt(st.nextToken());//bitter
        }

        int answer = subSet(0,1,0);
        System.out.println(answer);

    }

    public static int subSet(int index,int mulSour,int sumBitter){//index 번째 재료를 고려한다,mulSour: 총 신맛,sumBitter: 총 쓴맛
        if(index == n){//부분집합 원소 수가 n개면
            if(mulSour == 1 && sumBitter == 0){//재료를 하나도 포함하지 않을 경우 조건을 만족하지 못한다. (재료 1개 이상)
                return Integer.MAX_VALUE; //Math.min으로 계산되지 않게 MAX 값을 return 한다
            }
            return Math.abs(mulSour - sumBitter);
        }

        int a = subSet(index + 1, mulSour * ingredient[index][0], sumBitter + ingredient[index][1]); //재료를 고른 경우
        int b = subSet(index + 1, mulSour, sumBitter); //재료를 안 고른 경우
        return Math.min(a,b);
    }

}
