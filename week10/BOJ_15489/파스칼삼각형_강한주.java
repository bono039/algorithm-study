import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] visited = new int[30][30];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());//r번째 줄
        int c = Integer.parseInt(st.nextToken());//c번째 수
        int w = Integer.parseInt(st.nextToken());//한변이 포함하는 수의 개수가 w개
        int total = 0;


        for(int i = 0; i <= (r+w-2); i++){//행
            for(int j = 0; j <= i; j++) {//열
                combination(i,j);
            }
        }

        int row = 1;//파스칼의 삼각형 계산시 열의 개수는 1개부터 2개,,3개,,씩 차례로 커진다.
        for(int i = r-1; i < r+w-1; i++){//행
            for(int j = c-1; j < (c-1)+row; j++){//열
                total += visited[i][j];
            }
            row++;
        }

        System.out.println(total);
    }

    static int combination(int n,int r) {
        if(visited[n][r] > 0) {//이미 방문했다면 그 값을 return
            return visited[n][r];
        }else if(r == 0 || n == r) {//nCr에서 n==r이고 r==0이면 값이 1이다
            return (visited[n][r] = 1);
        }else {//nCr = (n-1)C(r-1) + (n-1)Cr
            visited[n][r] = combination(n-1,r-1) + combination(n-1,r);//이부분을 계속 안써서 파스칼삼각형이 0으로 채워졌다...바본가?
            return visited[n][r];
        }
    }
}