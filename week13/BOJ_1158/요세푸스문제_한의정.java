import java.util.*;
import java.io.*;

public class 요세푸스문제_한의정 {
    static int N,K;
    static LinkedList<Integer> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        K = Integer.parseInt(str[1]);

        if(N == 1) {
            System.out.println("<1>");
            return;
        }

        for(int i = 1 ; i <= N ; i++)   q.add(i);

        int idx = K-1;
        sb.append("<" + q.remove(idx) + ", ");

        while(!q.isEmpty()) {
            idx = (idx + K -1) % q.size();
            int num = q.remove(idx);

            sb.append(num);
            if(q.size() != 0)
                sb.append(", ");
        }

        sb.append(">");
        System.out.println(sb.toString());
    }
}
