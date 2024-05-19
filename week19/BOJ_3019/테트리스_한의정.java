import java.util.*;
import java.io.*;

public class 테트리스_한의정 {
    static int C,P;
    static int[] map;

    // 빈 공간 갯수만 세어 타일 저장
    static int[][][] shape = {{{0}, {0,0,0,0}},
            {{0,0}},
            {{0,0,1}, {1,0}},
            {{1,0,0}, {0,1}},
            {{0,0,0}, {0,1}, {1,0,1}, {1,0}},
            {{0,0,0}, {0,0}, {0,1,1}, {2,0}},
            {{0,0,0}, {0,0}, {1,1,0}, {0,2}}
    };

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        C = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken()) -1;   // 떨어뜨리는 블록 번호

        map = new int[C];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < C ; i++) {  // 열
            map[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < shape[P].length ; i++) {
            for(int j = 0 ; j < C - shape[P][i].length + 1 ; j++) {
                int diff = map[j] - shape[P][i][0];
                boolean ok = true; // 각 번호에 맞는 빈 공간 수를 뺐을 때 모두 같은 값이 나오면 놓을 수 있는 자리

                for(int k = 1 ; k < shape[P][i].length ; k++) {
                    if(diff != map[j + k] - shape[P][i][k]) {
                        ok = false;
                        break;
                    }
                }

                if(ok)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}