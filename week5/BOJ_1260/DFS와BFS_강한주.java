import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];
        for(int i = 0; i < m; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            arr[num1][num2] = 1; //서로 연결되어 있다는 뜻
            arr[num2][num1] = 1; //서로 연결되어 있다는 뜻
        }

        dfs(v);

        for(int i = 0; i < n+1; i++){
            visited[i] = false;
        }
        System.out.println();

        bfs(v);

    }

    static void dfs(int node) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int j = 1; j < n + 1; j++) {
            if (arr[node][j] == 1 && visited[j] == false) {//서로 연결되어 있고 방문하지 않은 노드라면
                dfs(j);
            }
        }

    }
    static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        System.out.print(v+" ");

        while(!q.isEmpty()){
            int node = q.poll();

            for(int i = 1; i < n+1; i++){
                if(arr[node][i] == 1 && !visited[i]){
                    visited[i] = true;
                    System.out.print(i + " " );
                    q.add(i);
                }
            }
        }
        //잘못쓴 코드
//            for(int i = 1; i < n+1; i++){
//                if(arr[v][i] == 1 && !visited[i]){
//                    visited[i] = true;
//                    System.out.print(i+" ");
//
//                }
//            }
    }
}