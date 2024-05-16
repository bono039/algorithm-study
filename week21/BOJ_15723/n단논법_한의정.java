import java.util.*;
import java.io.*;

public class n단논법_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[][] connected = new boolean[26][26];

        while(N --> 0) {
            String[] str = br.readLine().split(" is ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);

            connected[a - 'a'][b - 'a'] = true;
        }

        // 플로이드-워셜
        for(int k = 0 ; k < 26 ; k++) {
            for(int i = 0 ; i < 26 ; i++) {
                for(int j = 0 ; j < 26 ; j++) {
                    if(i == j || j == k || k == i)  continue;

                    // i → k고, k → j면, i → j다.
                    if(connected[i][k] && connected[k][j]) {
                        connected[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        while(M --> 0) {
            String[] str = br.readLine().split(" is ");
            char a = str[0].charAt(0);
            char b = str[1].charAt(0);

            sb.append(connected[a - 'a'][b - 'a'] ? "T" : "F");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
