import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] tomato;
    static int n; static int m;
    static int[] dx = {-1,1,0,0};//북남서동
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        tomato = new int[n][m];
        Queue<int[]> queue = new LinkedList<>(); //토마토가 있는 좌표를 표현하기 위한 큐
        int cnt = 0; //토마토의 갯수를 세고, 나중에 검증하기 위한 변수
        int days = 0; //총 며칠이 걸리는지 세는 변수


        for(int i = 0; i < n; i++) {//map채우기
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if(tomato[i][j] == 1)queue.add(new int[]{i,j});
                else if(tomato[i][j] == 0)cnt++;
            }
        }

        while(cnt>0 && !queue.isEmpty()){//cnt>0이란 조건을 넣어줘야한다. 토마토가 다 채워져 있으면 작업을 수행할 이유가 없기 때문이다
            for(int i = queue.size(); i > 0; i--){//queue.size()만큼 반복을 설정하는게 중요하다!!
                int[] now = queue.poll();

                for(int j = 0; j < 4; j++){//주위에 토마토 확인
                    int nextX = now[0] + dx[j];
                    int nextY = now[1] + dy[j];

                    if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || tomato[nextX][nextY]!=0){
                        continue;
                    }

                    tomato[nextX][nextY] = 1;
                    cnt--; //전체 토마토의 개수에서 1개의 토마토가 익었으므로 --해준다
                    queue.add(new int[]{nextX,nextY});
                }
            }
            days++;
        }

        if(cnt==0){
            System.out.println(days);
        }else{
            System.out.println(-1);
        }

    }
}



