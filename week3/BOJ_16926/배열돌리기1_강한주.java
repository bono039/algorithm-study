import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[][] arr;
    static int n,m;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int curX = 0;
    static int curY = 0;
    static int dir = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int layer = Math.min(n,m)/2;

        for(int i = 0; i < layer; i++){//레이어의 수
            int round = 2*(n+m - 4*i)-4;
            int rotateNum = r % round; //총회전수
            curX = i; curY = i; //레이어가 바뀌면 회전 시작 위치도 (i,i)로 바뀐다

            for(int j = 0; j < rotateNum; j++){//레이어당 rotateNum만큼 회전한다
                int temp = arr[curX][curY];//첫시작 값을 저장하는 변수 temp, 숫자를 옮기면서 수를 저장하는 temp
                for(int k = 0; k < round; k++) {//레이어에 있는 모든 수를 옮겨야 한다
                    int value = temp;

                    while(true){
                        int moveX = curX + dx[dir];
                        int moveY = curY + dy[dir]; //다음 x,y위치
                        if(!isValid(moveX,moveY,i)){//만약 레이어i의 (moveX,moveY)위치가 유효하지 않다면
                            dir = (dir+1)%4; //방향을바꾼다
                        }else{
                            curX = moveX;
                            curY = moveY;
                            break;
                        }
                    }

                    temp = arr[curX][curY];//curX와 curY는 업데이트된 상태므로 temp도 업데이트 된다
                    arr[curX][curY] = value; //value는 업데이트 되기전 [curX,curY]에 있는 숫자다.

                }

            }

        }


        for(int i = 0; i < n; i++) {//전체 배열 출력
            for(int j = 0; j < m; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }

    static boolean isValid(int x,int y,int i){//이동했을때 범위가 유효한지 확인
        return (x>=i && x<n-i) && (y>=i && y<m-i);
    }

}