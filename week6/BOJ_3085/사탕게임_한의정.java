import java.util.*;
import java.io.*;

public class 사탕게임_한의정 {
    static int N;
    static char[][] arr;

    static int max = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];

        for(int i = 0 ; i < N ; i++) {
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        // 좌우 두 점 골라 확인하기
        for(int i = 0 ; i < N ; i++) {          // 행
            for(int j = 0 ; j < N - 1 ; j++) {  // 열
                // swap하기
                char c = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = c;

                // 최대 사탕 갯수 찾기
                search();

                // 원상복구
                c = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = c;
            }
        }


        // 위아래 두 점 골라 확인하기
        for(int i = 0 ; i < N ; i++) {          // 열
            for(int j = 0 ; j < N - 1 ; j++) {  // 행
                // swap하기
                char c = arr[j][i];
                arr[j][i] = arr[j + 1][i];
                arr[j + 1][i] = c;

                // 최대 사탕 갯수 찾기
                search();

                // 원상복구
                c = arr[j][i];
                arr[j][i] = arr[j + 1][i];
                arr[j + 1][i] = c;
            }
        }

        System.out.println(max);
    }

    private static void search() {
        // 가장 긴 연속 부분 "행" 찾기
        for(int i = 0 ; i < N ; i++) {          // 행
            int cnt = 1;

            for(int j = 0 ; j < N - 1 ; j++) {  // 열
                if(arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                max = Math.max(max, cnt);
            }
        }

        // 가장 긴 연속 부분 "열" 찾기
        for(int i = 0 ; i < N ; i++) {          // 열
            int cnt = 1;

            for(int j = 0 ; j < N - 1 ; j++) {  // 행
                if(arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                }
                else {
                    cnt = 1;
                }

                max = Math.max(max, cnt);
            }
        }
    }
}
