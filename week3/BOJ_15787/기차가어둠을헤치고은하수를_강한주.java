import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[][] train;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        train = new boolean[n+1][21];

        for(int i = 0 ; i < m; i++){
            st = new StringTokenizer(br.readLine());

            int orderNum = Integer.parseInt(st.nextToken()); // 명령
            int trainNum = Integer.parseInt(st.nextToken()); // 기차 번호

            if(orderNum == 1){
                int sit = Integer.parseInt(st.nextToken());
                train[trainNum][sit] = true;
            }else if(orderNum == 2){
                int sit = Integer.parseInt(st.nextToken());
                train[trainNum][sit] = false;
            }else if(orderNum == 3){
                for(int j = 20; j>=2 ; j--){
                    train[trainNum][j] = train[trainNum][j-1];
                }
                train[trainNum][1] = false;

            }else if(orderNum == 4){
                for(int j = 1; j<20 ; j++){
                    train[trainNum][j] = train[trainNum][j+1];
                }
                train[trainNum][20] = false;

            }
        }

        Set<String> set = new HashSet<>();

        for(int i = 1; i <= n; i++){
            String temp = "";
            for(int j = 1; j <= 20; j++){
                if(train[i][j])temp+="1";
                else temp+="0";
            }
            set.add(temp);
        }

        System.out.println(set.size());

    }

}