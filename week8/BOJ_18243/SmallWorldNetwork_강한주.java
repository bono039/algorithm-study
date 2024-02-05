import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n,k;
    static ArrayList<Integer>[] arr;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());//노드의 수 = 사람의 수
        k = Integer.parseInt(st.nextToken());//친구 관계의 수

        arr = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){
            arr[i] = new ArrayList<>();
        }

        for(int i = 0; i < k ; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a].add(b);
            arr[b].add(a);//양방향 관계를 추가해야한다.
        }

//        bfs(1); 이라 생각해서 틀렸다.

        int maxDistance = 0;//네트워크 상에서 가장 긴 경로
        for(int i = 1; i <= n; i++){
            visited = new int[n+1]; //i번째 노드가 다른 노드들을 방문했는지 표시하는 배열
            bfs(i);//i번째를 기준으로 다른 노드들의 최단 거리가 얼마인지 BFS를 써서계산
            for(int j = 1; j <= n; j++){//BFS후 visitied배열 검사
                if(visited[j] == 0 && i != j){//만약 i번째 노드가 방문을 못하는 j가 있으면 Big World다
                    System.out.println("Big World!");
                    return;
                }
                maxDistance = Math.max(visited[j], maxDistance);
            }
        }

        if(maxDistance > 6){//가장 긴 경로가 6을 넘으면 Big World
            System.out.println("Big World!");
        }else{
            System.out.println("Small World!");
        }
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int next : arr[now]){

                if(visited[next]==0){
                    visited[next] = visited[now]+1;//거리 갱신 .. 이생각을 왜 못했지? distance전역으로 두고 거기에 너무 집착함
                    q.add(next);
                }
            }
        }
    }
}
