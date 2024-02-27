import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int c;
    static int answer = 0;
    static List<Integer> obj = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //물건의 개수
        c = Integer.parseInt(st.nextToken()); //무게

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            obj.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(obj); //무게순서대로 정렬

        combination(0,0,0);
        System.out.println(answer);

    }

    static void combination(int pick,int totalWeight,int objNum) {
        if(totalWeight == c) {//종료 조건
            System.out.println(1);
            System.exit(0);
        }

        if(pick == 3 || totalWeight > c || objNum >= n) {
            return;
        }

        //물건을 골랐을 때
        combination(pick + 1,totalWeight + obj.get(objNum), objNum + 1);
        //물건을 안골랐을 때
        combination(pick,totalWeight,objNum + 1);
        return;

    }
}