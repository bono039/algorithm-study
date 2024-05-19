import java.util.*;
import java.io.*;

public class 두스티커_한의정 {
    static int H,W,N;
    static List<Sticker> list = new ArrayList<>();  // 스티커 위치 저장 리스트
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        while(N --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if((r > H && r > W) || (c > W && c > H))    continue;   // 격자 범위 벗어나면 pass
            list.add(new Sticker(r, c));
        }

        solve();
        System.out.println(answer);
    }

    // 모든 스티커 붙이는 경우 구하는 함수
    private static void solve() {
        // 첫 번째 스티커는 (0,0) 기준으로 붙이기
        for(int i = 0 ; i < list.size() ; i++) {
            Sticker now = list.get(i);
            int size = now.r * now.c;

            // 1번 스티커 붙이기
            int tmpR = H - now.r;
            int tmpC = W - now.c;

            // 1번 스티커 붙이기 성공한 경우
            if(tmpR >= 0 && tmpC >= 0)
                second(i, tmpR, tmpC, size);

            // 1번 스티커 회전해서 붙이기
            tmpR = H - now.c;
            tmpC = W - now.r;

            // 회전한 1번 스티커 붙이기 성공한 경우
            if(tmpR >= 0 && tmpC >= 0)
                second(i, tmpR, tmpC, size);
        }
    }

    // 2번째 스티커 붙이는 함수
    private static void second(int idx, int rr, int cc, int size) {
        int secondSize = 0;

        for(int i = idx + 1 ; i < list.size() ; i++) {
            Sticker now = list.get(i);

            int tmpSize = now.r * now.c;    // 2번째 스티커 넓이

            // 모눈 종이 영역에 2번째 스티커를 그대로 or 회전해 붙였을 때 성공한 경우
            if((now.r <= rr && now.c <= W) || (now.r <= H && now.c <= cc)
                    || (now.c <= rr && now.r <= W) || (now.c <= H && now.r <= cc))
                secondSize = Math.max(secondSize, tmpSize);
        }

        // 2번째 스티커 붙이기 성공 시, 최대 넓이 갱신
        if(secondSize != 0)
            answer = Math.max(answer, size + secondSize);
    }
}

class Sticker {
    int r, c;

    public Sticker(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

