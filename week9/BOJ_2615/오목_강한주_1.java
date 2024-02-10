import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr = new int[19][19];

    //방향을 설정하는 2차원 배열 , row방향,col방향,대각선1방향,대각선2방향
    static int[][] dir = {{0,1},{1,0},{1,1},{-1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 19; i++) {//입력
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int j = 0; j < 19; j++){//가장 왼쪽의 좌표가 출력되어야 하므로 j부터 시작
            for(int i = 0; i < 19; i++){
                if(arr[i][j] > 0){//흰색이나 검정색 바둑알이 있다면
                    for(int k = 0; k < 4; k++){//row,col,diag1,diag2방향
                        int ax = i; //x좌표
                        int ay = j; //y좌표
                        int cnt = 1; //같은 색깔의 바둑알 개수

                        //증가하는 방향 탐색
                        while(true){
                            ax += dir[k][0];
                            ay += dir[k][1];

                            if(isValid(ax,ay)){//유효한 범위인지 확인
                                if(arr[ax][ay] == arr[i][j]) cnt++; //만약 전 바둑알과 색이 같다면 cnt++
                                else break;
                            }else break;
                        }

                        ax = i;
                        ay = j; //전에 방향 값을 더해준걸 다 초기화시킨다

                        //감소하는 방향 탐색
                        while(true){
                            ax -= dir[k][0];
                            ay -= dir[k][1];

                            if(isValid(ax,ay)) {
                                if(arr[i][j] == arr[ax][ay]) cnt++;
                                else break;
                            }else break;
                        }

                        if(cnt == 5){
                            System.out.println(arr[i][j]);
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
        return (x >= 0 && x < 19) && (y >= 0 && y < 19);
    }
}
