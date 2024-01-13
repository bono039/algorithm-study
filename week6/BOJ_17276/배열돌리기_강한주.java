import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int d;
    static int[][] arr;
    static int[][] copy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            if(d<0)d+=360;
            d /= 45;//총 몇번 회전할지

            arr = new int[n][n];
            copy = new int[n][n];
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < n; k++){
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    copy[j][k] = arr[j][k];
                }
            }

            while(d-- > 0){
                rotate();
            }
            print();

        }
    }


    public static void rotate(){

        for(int i = 0; i<n; i++){
            copy[i][n/2] = arr[i][i]; //대각선을 열로 이동
            copy[i][i] = arr[n/2][i];//행을 대각선으로 이동
            copy[n/2][i] = arr[n-i-1][i];//부대각선을 행으로이동
            copy[n-i-1][i] = arr[n-i-1][n/2]; //열을 부대각선으로 이동
        }

    }

    public static void print(){
        for(int i = 0; i < n; i++){
            for(int j =0; j < n; j++){
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();

        }
    }
}