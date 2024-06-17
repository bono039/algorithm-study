package BOJ_2251;

import java.util.*;
import java.io.*;
// https://www.acmicpc.net/problem/2251
//
public class 물통_한의정 {
    static int[] from = {0,0,1,1,2,2};
    static int[] to = {1,2,0,2,0,1};

    static int[] arr = new int[3];
    static boolean[][] visited = new boolean[201][201];

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < 3 ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        list.add(arr[2]);

        bfs();

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < list.size() ; i++) {
            sb.append(list.get(i) + " ");
        }
        System.out.println(sb.toString());
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});

        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int a = now[0];
            int b = now[1];
            int c = arr[2] - a - b;

            for(int i = 0 ; i < 6 ; i++) {
                int[] next = {a,b,c};

                next[to[i]] += next[from[i]];
                next[from[i]] = 0;

                if(next[to[i]] > arr[to[i]]) {
                    next[from[i]] = next[to[i]] - arr[to[i]];
                    next[to[i]] = arr[to[i]];
                }

                if(!visited[next[0]][next[1]]) {
                    visited[next[0]][next[1]] = true;
                    q.add(new int[] {next[0], next[1]});

                    if(next[0] == 0)
                        list.add(next[2]);
                }
            }
        }
    }
}
