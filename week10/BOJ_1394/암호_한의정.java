import java.util.*;
import java.io.*;

public class 암호_한의정 {
    static final int MOD = 900528;

    static String words, pwd;
    static int[] arr = new int[200];    // 해당 문자가 쓰인 첫 순서 기록용 배열
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        words = br.readLine();
        pwd = br.readLine();

        // 사용 가능한 문자열에 대한 정보 기록
        for(int i = 0 ; i < words.length() ; i++) {
            int idx = words.charAt(i) - '!';    // ! : 사용될 수 있는 가장 작은 수의 문자

            if(arr[idx] == 0)   // 해당 문자가 처음으로 등장하는 경우에만 인덱스 기록
                arr[idx] = i + 1;
        }

        // 컴퓨터 암호에 대한 처리
        for(int i = 0 ; i < pwd.length() ; i++) {
            int idx = pwd.charAt(i) - '!';

            ans *= words.length();
            ans += arr[idx];
            ans %= MOD;
        }

        System.out.println(ans);
    }
}
