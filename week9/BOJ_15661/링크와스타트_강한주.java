import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] ability;
    static int n,result;
    static boolean[] visit; //부분집합을 구하기 위한 방문처리 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        ability = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = Integer.MAX_VALUE;
        visit = new boolean[n];
        subSet(0);
        System.out.println(result);

    }

    static void subSet(int index){
        if(index == n){//n+1번째 사람은 없으므로 종료조건으로 설정한다
            int start = 0;
            int link = 0;

            //같은 팀원들끼리 능력치 합산
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    if(visit[i] != visit[j]) continue;//i번째 팀원과 j번째 팀원이 같은 팀이 아니라면 패스.

                    //i번째 팀원과 j번째 팀원이 같은 팀이라면 능력치를 계산할 수 있다
                    if(visit[i]){//start 팀원이라면
                        start += ability[i][j] + ability[j][i];
                    }else {//link 팀원이라면
                        link += ability[i][j] + ability[j][i];
                    }
                }
            }

            int diff = Math.abs(start - link);
            result = Math.min(result,diff);

            return;
        }

        visit[index] = true; // index번째 사람을 start 팀에 넣는 경우
        subSet(index + 1);
        visit[index] = false; //index번째 사람을 start 팀에 넣지 않는 경우
        subSet(index + 1);
    }
}