import java.util.*;

public class Main {
    static int ans = 0;
    static int computerNum;static int connect;
    static boolean[] visited;
    static int[][] computer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        computerNum = sc.nextInt();
        connect = sc.nextInt();
        computer = new int[computerNum+1][computerNum+1];
        visited = new boolean[computerNum+1];

        for(int i = 0 ; i < connect; i++){
            int computer1 = sc.nextInt();//virus
            int computer2 = sc.nextInt();//to
            computer[computer1][computer2] = 1;
            computer[computer2][computer1] = 1;//이부분 !!!!
        }

        findVirus(1);
        System.out.println(ans);
    }

    static void findVirus(int i){
        visited[i] = true;
        for(int j = 1; j < computerNum+1; j++){
            if(computer[i][j]==1 && visited[j]==false){
                ans++;
                findVirus(j);
            }
        }
    }
}