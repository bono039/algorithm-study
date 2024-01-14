import java.util.*;
import java.io.*;

public class 스위치켜고끄기_한의정 {
    static int N, M;
    static int[] switches;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        switches = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            solve(gender, pos);
        }

        print();
    }

    private static void solve(int gender, int pos) {
        if(gender == 1) {   // 남자인 경우
            for(int i = pos ; i <= N ; i += pos) {  // 받은 수의 배수인 경우 상태 변경
                switches[i] = switches[i] == 0 ? 1 : 0;
            }
        }
        else {  // 여자인 경우
            switches[pos] = switches[pos] == 0 ? 1 : 0;     // 현재 칸은 무조건 상태 변경

            int l = pos - 1;    // 현재 칸의 왼쪽 위치
            int r = pos + 1;    // 현재 칸의 오른쪽 위치

            while(1 <= l && r <= N && l <= r) {
                if(switches[l] == switches[r]) {    // 좌우 두 칸의 값이 대칭인 경우

                    // 좌우 두 칸 다 상태 변경
                    switches[l] = switches[l] == 0 ? 1 : 0;
                    switches[r] = switches[r] == 0 ? 1 : 0;

                    // 좌우 양 옆으로 범위 확장
                    l--;
                    r++;
                }
                else {  // 좌우 값 대칭이 아닌 경우, 종료
                    break;
                }
            }
        }
    }

    // 출력 메소드
    private static void print() {
        StringBuilder sb = new StringBuilder();

        for(int i = 1 ; i <= N ; i++) {
            sb.append(switches[i] + " ");

            if(i % 20 == 0) {   // 한 줄에 20개씩 출력하기 위해 한 줄 띄어쓰기
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
