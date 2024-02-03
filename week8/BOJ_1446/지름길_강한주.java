import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<int[]> list[]; //이게 신기하네
    static int n,d;
    static int max = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//지름길의 개수
        int d = Integer.parseInt(st.nextToken());//고속도로 d킬로미터
        list = new ArrayList[10001];

        for(int i = 0; i < list.length; i++){//초기화
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[start].add(new int[]{end,len});
        }

        int dp[] = new int[10001];//dp[i]:i까지의 최소거리
        for(int i = 0; i < dp.length; i++){//dp 초기화
            dp[i] = i;
        }

        for(int i = 0; i <= d; i++){//(주의) 이 범위도 0부터 시작하면 안된다
            if(i != 0)dp[i] = Math.min(dp[i-1]+1,dp[i]); //내가 생각못했던 코드

            if(list[i].size() > 0){//만약 i에서 지름길이 있다면
                for(int tmp[] : list[i]){
                    int end = tmp[0];
                    int len = tmp[1];//지름길 길이
                    if(dp[end] > dp[i] + len){//지름길을 통해가는게 더 짧은거리라면
                        dp[end] = dp[i]+len;//dp 업데이트
                    }
                }
            }
        }

        System.out.println(dp[d]);
    }
}