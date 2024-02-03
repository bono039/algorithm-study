import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+1][n+1];// arr[i][j] : i에서 j까지 가는 최소친구연결
        int max = Integer.MAX_VALUE >> 2; //오버플로우가 발생할 수 있으므로 /2

        for(int i = 1; i <= n; i++){
            String str = br.readLine();
            for(int j = 1; j <= n; j++){
                char ch = str.charAt(j-1);

                if(i == j)continue;//나와 나는 친구가 아니다
                arr[i][j] = ch == 'Y' ? 1 : max;
            }
        }

        //플루이드 와샬
        for(int i = 1; i <= n; i++){ //i는 거쳐가는 노드의 인덱스
            for(int j = 1; j <= n; j++){//경로의 시작노드 j
                for(int k = 1; k <= n; k++){//경로의 끝 노드 k
                    if(j==k) continue;//자신끼리는 친구가 아니다.
                    //j부터k까지의 경로와, j부터 i를 거쳐 i에서 k까지의 경로 중 최소값을 찾는다.
                    arr[j][k] = Math.min(arr[j][k],arr[j][i]+arr[i][k]);
                }
            }
        }

        int ans = 0;

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(arr[i][j] ==2 || arr[i][j] == 1){
                    cnt++;
                }
            }
            ans = Math.max(cnt,ans);
        }

        System.out.println(ans);

    }
}



