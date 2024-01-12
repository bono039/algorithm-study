import java.util.*;
import java.io.*;

public class 별찍기19_한의정 {
    static int N;
    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        N = 4 * N - 3;  // 등차수열로 구함

        star = new char[N][N];
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                star[i][j] = ' ';
            }
        }

        makeStar(0, N); // 별 찍기 - 재귀

        // 출력하기
        StringBuilder sb = new StringBuilder();
        for(char[] ch : star) {
            for(char c : ch) {
                sb.append(c);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void makeStar(int s, int len) {
        if(len <= s)    return;

        for(int i = s ; i < len ; i++) {
            star[s][i] = '*';        // 맨 위 가로줄
            star[len - 1][i] = '*';  // 맨 아래 가로줄
            star[i][s] = '*';        // 왼쪽 세로줄
            star[i][len - 1] = '*';  // 오른쪽 세로줄
        }

        makeStar(s + 2, len - 2);   // 재귀
    }
}
