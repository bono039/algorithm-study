import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map = new int[5][5]; //빙고판
    static int bingo = 0;
    static int turn = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0 ; i < 5 ; i++){//빙고판 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < 5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0 ; j <5; j++){
                int num = Integer.parseInt(st.nextToken()); //사회자가 부른 숫자
                writeZero(num);

                col();
                row();
                diag1();
                diag2();

                if(bingo >= 3){ //bingo == 3으로 하면 틀린다!!
                    System.out.println(turn);
                    System.exit(0);
                }

                bingo = 0; // 빙고는 초기화 해야한다
                turn++;
            }
        }

    }

    static void writeZero(int num){
        for(int i = 0 ; i <5; i++) {
            for(int j =0 ; j<5; j++){
                if(num == map[i][j]){
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }

    static void col(){
        for(int i = 0; i <5; i++){
            int count = 0;
            for(int j =0; j <5; j++){
                if(map[j][i] == 0)count++;
                if(count == 5)bingo++;
            }
        }
    }

    static void row(){
        for(int i = 0; i <5; i++){
            int count = 0;
            for(int j =0; j <5; j++){
                if(map[i][j] == 0)count++;
                if(count == 5)bingo++;
            }
        }
    }

    static void diag1(){
        int count = 0;
        for(int i =0; i <5;i++) {
            if(map[i][i] == 0)count++;
            if(count == 5)bingo++;
        }
    }

    static void diag2(){
        int count = 0;
        for(int i = 0; i<5; i++) {
            if(map[i][4-i] == 0)count++;
            if(count == 5)bingo++;
        }
    }

}
