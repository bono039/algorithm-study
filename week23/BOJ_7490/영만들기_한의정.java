import java.io.*;

public class 영만들기_한의정 {
    static int T, N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            N = Integer.parseInt(br.readLine());
            dfs(1, 1, 1, 0, "1");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int now, int num, int sign, int sum, String str) {
        if(now == N) {
            sum = sum + (num*sign);

            if(sum == 0)
                sb.append(str).append("\n");
            return;
        }

        dfs(now+1, num*10 + (now+1), sign, sum,              str + " " + String.valueOf(now+1));
        dfs(now+1, now+1,            1,    sum + (num*sign), str + "+" + String.valueOf(now+1));
        dfs(now+1, now+1,           -1,    sum + (num*sign), str + "-" + String.valueOf(now+1));
    }
}