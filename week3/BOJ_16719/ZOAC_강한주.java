import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    static String str;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));//처음 들어온 String

        str = br.readLine();
        visited = new boolean[str.length()];

        zoac(0,str.length()-1); //idx가 0~str.length()-1 중 사전상 가장 앞에 나온 숫자를 찾는 메서드

        System.out.println(sb.toString());

    }

    static void zoac(int start,int end){
        if(start > end) return;

        int idx = start;

        for(int i = start; i <= end; i++){
            if(str.charAt(idx) > str.charAt(i)){//사전상, 가장 앞에 오는 알파벳을 찾는다
                idx = i;
            }
        }

        visited[idx] = true; //가장 앞에오는 알파벳을 찾았으므로 true로 전환한다

        for(int i = 0; i < str.length(); i++){
            if(visited[i]){
                sb.append(str.charAt(i));
            }
        }

        sb.append("\n");

        zoac(idx+1,end); //idx+1 ~ end범위를 재귀로 구현한다
        zoac(start,idx-1); //idx+1 ~ end범위를 재귀로 다 구현한 후!!에 start ~idx-1범위를 재귀로 구현한다

    }

}