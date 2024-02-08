import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());//몇 번 숫자를 불렀는지
        int ans = 0; //총 후보 숫자의 개수

        int[] arr = new int[1000];//0~999까지의 배열 생성
        for(int i = 123; i <= 987; i++){//주어지는 숫자는 서로 중복되지 않고, 0이 들어가 있지 않다
            String str = String.valueOf(i);

            if(str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)
                    || str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0'){
                arr[i] = -1; //중복되는 숫자가 있거나 0이 있으면 -1로 후보에서 제외한다
            }
        }


        for(int i = 0; i < n; i++) {//숫자 물어보기 시작
            st = new StringTokenizer(br.readLine());

            String qNum = st.nextToken();//물어본 숫자
            int strike = Integer.parseInt(st.nextToken()); //총 스트라이크 횟수
            int ball = Integer.parseInt(st.nextToken());//총 볼 횟수

            for(int j = 123; j <= 987; j++){
                if(arr[j] == -1)continue;//전에 후보에서 제외된 숫자는 continue

                String compare = String.valueOf(j);//물어본 숫자와 비교할 숫자
                int strikeNum = 0; //현재 숫자와 물어본 숫자를 비교해서 strike count
                int ballNum = 0;

                for(int k = 0; k < 3; k++){//strike 검사
                    if(compare.charAt(k) == qNum.charAt(k)){
                        strikeNum++;
                    }
                }

                for(int k = 0; k < 3; k++){//ball 검사
                    for(int l = 0; l < 3; l++){
                        if((qNum.charAt(k) == compare.charAt(l)) && (k != l)){
                            ballNum++;
                        }
                    }
                }

                if((strike != strikeNum) || (ball != ballNum)){
                    arr[j] = -1; //strike와 ball count가 서로 다르면 후보에서 제외한다
                }else if((strike == strikeNum) && (ball == ballNum)){
                    arr[j]++;
                }
            }
        }

        for(int i = 123; i <= 987; i++){
            if(arr[i] != -1)ans++;
        }

        System.out.println(ans);

    }
}
