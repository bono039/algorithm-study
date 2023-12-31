import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] map = new int[19][19];
    static int[][] d = {{0,1},{1,0},{1,1},{-1,1}}; //새로알게된부분

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 19; i++) {//입력값 받기
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }

        for(int j = 0; j < 19; j++){//j부터 시작해서 가장 왼쪽위의 좌표가 출력된다 !!!!!!!!!!
            for(int i = 0; i < 19; i++){
                if(map[i][j]>0){
                    for(int k = 0; k < 4; k++){
                        int ax = i; //x좌표
                        int ay = j; //y좌표
                        int cnt = 1; //바둑알 개수

                        //증가하는 방향 탐색
                        while(true){
                            ax += d[k][0];
                            ay += d[k][1];
                            if(isValid(ax,ay)){
                                if(map[i][j]==map[ax][ay])cnt++;
                                else break;
                            }else break;
                        }

                        ax = i;//초기화
                        ay = j;

                        //감소하는 방향의 탐색
                        while( true) {
                            ax -= d[k][0];
                            ay -= d[k][1];
                            if (isValid(ax,ay)) {
                                if(map[i][j] ==map[ax][ay])cnt ++;
                                else break;

                            } else break;
                        }

                        if(cnt == 5){
                            System.out.println(map[i][j]);
                            System.out.println((i+1)+" "+(j+1));
                            return;
                        }

                    }

                }
            }
        }

        System.out.println("0");
    }


    static boolean isValid(int x, int y){
        return (x>=0 && x<19) && (y>=0 && y<19);
    }
}