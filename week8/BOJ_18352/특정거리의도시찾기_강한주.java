import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] Arr;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());//도시의 개수
        int m = Integer.parseInt(st.nextToken());//도로의 개수
        int k = Integer.parseInt(st.nextToken());//최단 거리 k
        int x = Integer.parseInt(st.nextToken());//출발 도시 번호

        Arr = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++){//도시의 개수만큼 ArrayList를 생성한다.
            Arr[i] = new ArrayList<>();
        }

        for(int i = 1; i < m+1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Arr[a].add(b); //a번집에서 b집으로 갈 수 있는 단방향 도로 추가
        }

        visited = new int[n+1]; //방문 배열 초기화
        for(int i = 0; i <= n; i++){
            visited[i] = -1; //방문하지 않았다면 -1
        }

        bfs(x); //시작집부터 bfs 시작

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(visited[i] == k){//최소 거리k 에 방문한 집이 있다면 answer에 추가
                answer.add(i);
            }
        }

        Collections.sort(answer); //오름차순 정렬

        if(answer.size()==0){//만약 조건에 해당하는 집이 없다면 -1출력
            System.out.println(-1);
        }else{
            for(int num:answer){
                System.out.println(num);
            }
        }

    }

    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start]++; //visited 배열에 현재 노드 방문을 기록한다

        while(!queue.isEmpty()){
            int now = queue.poll();//현재 집 번호

            for(int destination : Arr[now]){//현재 집과 연결된 집들
                if(visited[destination]==-1){//방문한 집이 아니라면
                    visited[destination] = visited[now] + 1;//방문 거리 기록
                    queue.add(destination);
                }
            }
        }
    }
}
