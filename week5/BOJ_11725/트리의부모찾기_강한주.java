import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {//ArrayList 생성
            edges.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            edges.get(node1).add(node2); //node1과 node2가 연결되어있다고 표시
            edges.get(node2).add(node1); //서로 연결
        }

        dfs(1);

        for (int i = 2; i <= n; i++) {//2번부터 N번 노드까지의 부모 출력
            System.out.println(parent[i]);
        }
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int v : edges.get(node)) {//node랑 연결되어있는 번호들을 탐색한다
            if (!visited[v]) {//만약 번호v를 방문하지 않았다면 dfs
                parent[v] = node;
                dfs(v);
            }
        }
    }
//잘못쓴코드
//    for(int i = 0;i<n-1;i++){
//        if (visited[node1] && visited[node2]) {
//            continue;
//        } else if (visited[node1]) {//node1번을 방문했나? 방문이 되어있으면 node2는 당연히 node1의 자식이 된다
//            visited[node2] = true; //node2 방문처리
//            parent[node2] = node1;//node1의 자식은 node2
//        } else if (visited[node2]) {//node1번을 방문한적이없고 node2번을 방문한적이 있으면 node2번이 node1번의 부모가 된다
//            visited[node1] = true;
//            parent[node1] = node2;
//        } else {//둘다 방문한 노드가 아닐 경우
//            visited[node1] = true;
//            parent[node1] = node2;
//        }
//    }

}