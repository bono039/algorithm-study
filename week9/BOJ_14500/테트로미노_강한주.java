import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,m;
    static int max = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0}; //상하좌우
    static int[] dy = {0,0,1,-1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){//입력
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = true; //일단 방문 처리를 한다
                dfs(i,j,1,arr[i][j]); //모양에 집착할 필요가 없다.
                //DFS 무작위 4방향으로 뻗어나가게 두면 그게 테트로미노의 전체 모양이 된다.
                visited[i][j] = false; //방문 처리를 했던걸 취소한다
            }
        }

        System.out.println(answer);

    }

    static void dfs(int x,int y,int depth,int sum){
        if(depth == 4){//깊이가 4라면 4개의 조각을 다 배치한 것이므로 종료해야 한다.
            answer = Math.max(answer,sum); //지금까지의 합과 answer을 비교해서 더 큰 값을 answer로 바꾼다
            return;
        }

        for(int i = 0; i < 4; i++){//총 4개의 방향이 있다 (상하좌우)
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(!isValid(nextX,nextY)) continue;//유효하지 않은 범위면 패스
            if(visited[nextX][nextY]) continue;//이미 방문한 칸이라면 다시 갈 필요가 없으므로 패스

            if(depth == 2) { //ㅗ 모양을 만들어줘야 할 경우 (ㅗ모양은 상하좌우 탐색으로는 만들 수 없다)
                //따라서 2번째 칸을 탐색할 때 3번째 탐색의 시작하는 위치를 2번째 칸에서 다시 한 번 탐색하도록 경우를 추가해준다.

                visited[nextX][nextY] = true;
                dfs(x,y,depth + 1,sum + arr[nextX][nextY]);//아래 dfs재귀와 비교를 해보자!
                visited[nextX][nextY] = false;
            }

            visited[nextX][nextY] = true;
            dfs(nextX,nextY,depth + 1,sum + arr[nextX][nextY]);
            visited[nextX][nextY] = false;
        }
    }

    static boolean isValid(int x, int y) {
        return (x >= 0 && x < n) && (y >= 0 && y < m);
    }
}