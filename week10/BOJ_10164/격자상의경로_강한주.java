import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] visited;
    static int n;
    static int m;
    static int startX;
    static int startY;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int num = 1;
        int ans = 0;

        visited = new int[n][m];
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                arr[i][j] = num++;
            }
        }

        if(k == 0) {//O표시되어 있는게 없다면
            startX = 0;
            startY = 0;
            ans = move(n-1,m-1);
        }else {//O표시가 있다면
            int kX = 0;
            int kY = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == k){
                        kX = i;
                        kY = j;
                        break;
                    }
                }
            }
            move(kX,kY); //일단 k가 있는 위치까지 이동을 한다
            startX = kX;
            startY = kY;
            ans = move(n-1,m-1);//다음 n-1,m-1까지 이동한다
        }

        System.out.println(ans);
    }

    static int move(int r,int c){
        if(!isValid(r,c)){//arr범위를 벗어난다면 return 0을 해야 한다.
            return 0;
        }else if(r == 0 || c == 0) {
            return visited[r][c] = 1; //테두리 쪽으로 갈 수 있는 최단길이는 1이다
        }else if(visited[r][c] > 0){
            return visited[r][c];
        }else {
            visited[r][c] = move(r,c-1) + move(r-1,c); //이 점화식을 세우는 것도 중요하다
            return visited[r][c];
        }
    }

    static boolean isValid(int r,int c){//유효 범위를 확인해주는 메서드
        return (r >= startX && r < n) && ( c >= startY && c < m);
    }

}