import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] pipe = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int ans = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            pipe[index] = true;
        }

        for (int i = 0; i < pipe.length; i++) {//파이프 수리 시작
            if (pipe[i]) {//파이프가 샌다면

                for (int j = 0; j < l; j++) {
                    if (i + j > pipe.length - 1) {//범위를 벗어나면 바로 종료
                        System.out.println(ans + 1);
                        System.exit(0);
                    }
                    pipe[i + j] = false;
                }
                ans++;
            }
        }

        System.out.println(ans);
    }
}