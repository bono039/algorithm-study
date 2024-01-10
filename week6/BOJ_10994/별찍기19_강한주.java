import java.util.*;

public class Main {
    static char star[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        n = 4 * n - 3; //가장끝 테두리 한 라인에 있는 별의 개수
        star = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                star[i][j] = ' ';
            }
        }

        Star_19(0, n);//(왼쪽위 꼭짓점,테두리 별의 개수)

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(star[i][j]);
            }
            System.out.println();
        }

    }

    public static void Star_19(int s, int len) {
        if (len<=s) return;

        for (int i = s; i < len; i++) {
            star[s][i] = '*'; //맨 위 가로줄
            star[len - 1][i] = '*'; //맨 아래 가로줄
            star[i][s] = '*'; //왼쪽 세로줄
            star[i][len - 1] = '*'; //오른쪽 세로줄
        }


        // 별을 좌표라고 생각할 때 겉테두리의 사각형과 가장 근접한 사각형을 보았을 때 2만큼의 차이가 난다
        Star_19(s + 2, len - 2);
    }

}
