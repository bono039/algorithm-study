import java.io.*;

public class 내선물을받아줘2_한의정 {
    static int N, cnt;
    static char[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = br.readLine().toCharArray();

        for(int i = 0 ; i < N-1 ; i++) {
            // EW 개수 구하기
            if(map[i] == 'E' && map[i+1] == 'W') {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
