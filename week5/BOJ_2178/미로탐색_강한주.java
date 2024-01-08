import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static int n; static int m;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};//북남서동
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int i = 0; i < n; i++) {//map채우기
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = s.charAt(j)-'0';//int로 표현
            }
        }

        visited = new boolean[n][m];
        visited[0][0] = true; //출발지는 true;
        bfs(0,0);
        System.out.println(map[n-1][m-1]);  //도착하면 얼마나 걸렸는지 출력한다

    }

    public static void bfs(int x,int y){
        Queue<int[]> q = new LinkedList<>();//좌표를 저장하기 위해 int배열을 사용했다
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4;i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m)continue; //배열의 범위를 벗어나면 방향 바꾼다
                if(visited[nextX][nextY] || map[nextX][nextY]==0)continue;//방문을 한 곳이거나 이동할 수 없으면 방향 바꾼다

                q.add(new int[]{nextX,nextY});
                map[nextX][nextY] = map[nowX][nowY]+1; //이동한거리를 표현한다
                visited[nextX][nextY] = true; //방문한곳으로 처리한다.
            }
        }
    }
}