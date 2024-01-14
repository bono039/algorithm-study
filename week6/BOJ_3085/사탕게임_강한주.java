package main;

import java.util.*;

public class Main {
    static int max = 1, n = 0;
    static char candy[][];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        candy = new char[n][n];

        for(int i = 0; i < n; i++){
            String tmp = sc.next();
            for(int j = 0; j < n; j++){
                candy[i][j] = tmp.charAt(j);
            }
            max = Math.max(max,chkRow(i)); //swap하기 전 행 체크
        }

        for(int i = 0; i < n; i++)max = Math.max(max,chkCol(i));//swap하기 전 열 체크

        for(int i = 0; i <n;i++){
            for(int j = 0; j < n; j++){
                if(j+1 < n){//열 범위가 벗어나지 않을 때
                    swap(i,j,i,j+1);//오른쪽이랑 swqp
                    max = Math.max(max,chkRow(i));
                    max = Math.max(max,chkCol(j));
                    max = Math.max(max,chkCol(j+1));
                    swap(i,j,i,j+1);
                }
                if(i+1 < n){
                    swap(i,j,i+1,j);
                    max = Math.max(max,chkRow(i));
                    max = Math.max(max, chkRow(i + 1));
                    max = Math.max(max, chkCol(j));
                    swap(i, j, i + 1, j);
                }
            }
        }


        System.out.println(max);
    }

    static void swap(int x1,int y1,int x2,int y2){
        char tmp = candy[x1][y1];
        candy[x1][y1] = candy[x2][y2];
        candy[x2][y2] = tmp;
    }

    static int chkRow(int x){
        int tmp = 1, res = 1;
        char ch = candy[x][0];//x행의 1열
        for(int i = 1; i < n; i++){
            if(candy[x][i] != ch){
                ch = candy[x][i];
                res = Math.max(res,tmp);
                tmp = 1;
            }else tmp++;
        }
        return Math.max(res,tmp);
    }

    public static int chkCol(int y) {
        int tmp = 1, res = 1;
        char ch = candy[0][y];
        for(int i = 1; i < n; i++) {
            if(candy[i][y] != ch) {
                ch = candy[i][y];
                res = Math.max(res, tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(res, tmp);
    }
}



