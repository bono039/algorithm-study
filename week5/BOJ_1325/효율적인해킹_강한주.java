import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] arr;
    static boolean[] visited;
    static int[] hackCom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        for(int i = 0; i<n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            arr[com1].add(com2);
        }

        hackCom = new int[n+1];
        int max = 0;

        for(int i = 1; i<= n; i++){
            visited = new boolean[n+1];
            bfs(i);
        }

        for(int i = 1; i <=n ; i++){
            max = Math.max(max,hackCom[i]);
        }
        //System.out.println(max);
        for(int i = 0; i < hackCom.length; i++){
            if(hackCom[i] == max) System.out.print(i+" ");
        }


    }

    static void bfs(int node){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int next:arr[num]){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    hackCom[next]++;
                }
            }
        }

    }

}
