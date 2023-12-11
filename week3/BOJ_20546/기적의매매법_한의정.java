import java.util.*;
import java.io.*;

public class 기적의매매법_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[14];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 14 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // [준현]
        int money1 = N; // 남은 현금
        int stock1 = 0; // 보유 주식 수

        // 최대한 많이 사 -> 그리디
        for(int i = 0 ; i < arr.length ; i++) {
            if(money1 / arr[i] > 0) {
                int cnt = money1 / arr[i];
                stock1 += cnt;
                money1 -= arr[i] * cnt;
            }
        }


        // [성민]
        int money2 = N; // 남은 현금
        int stock2 = 0; // 보유 주식 수

        for(int i = 0 ; i < arr.length - 3 ; i++) {
            // 3일 연속 가격이 전일 대비 상승한다면, 다 팔아 (전량 매도)
            if((arr[i] < arr[i + 1]) && (arr[i + 1] < arr[i + 2])) {
                if(stock2 == 0) continue;

                money2 += arr[i + 3] * stock2;
                stock2 = 0;
            }
            // 3일 연속 가격이 전일 대비 하락한다면, 즉시 다 사 (전량 매수)
            else if((arr[i] > arr[i + 1]) && (arr[i + 1] > arr[i + 2])) {
                if(money2 / arr[i + 3] > 0) {
                    int cnt = money2 / arr[i + 3];
                    stock2 += cnt;
                    money2 -= arr[i + 3] * cnt;
                }
            }
        }

        // 둘 중 누가 더 높은 수익률 내는지 (보유 현금 + 1.14 주가 * 주식 수)
        int profit1 = money1 + arr[arr.length - 1] * stock1;
        int profit2 = money2 + arr[arr.length - 1] * stock2;

        if(profit1 > profit2) {
            System.out.println("BNP");
        }
        else if(profit1 < profit2) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
}
