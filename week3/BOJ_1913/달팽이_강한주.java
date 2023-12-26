import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int curX = 0; static int curY = 0;
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int input = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int num = n*n;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[curX][curY] = num;

                int moveX = curX + dx[dir];
                int moveY = curY + dy[dir];
                if(!isValid(moveX,moveY) || arr[moveX][moveY]!=0){
                    dir = (dir+1)%4;
                }
                curX = curX + dx[dir];
                curY = curY + dy[dir];

                num--;
            }
        }

        StringBuilder sb = new StringBuilder();

        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j] + " ");
                if(input == arr[i][j]) {
                    x = i+1;
                    y = j+1;
                }
            }
            sb.append("\n");
        }
        sb.append(x+" "+y);
        System.out.println(sb);

    }

    static boolean isValid(int x, int y){
        return (x>=0 && x<arr.length) && (y>=0 && y<arr.length);
    }

}