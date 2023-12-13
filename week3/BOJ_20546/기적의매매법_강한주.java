package main;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cash = sc.nextInt();
        int[] stock = new int[15];


        for(int i = 1; i < 15; i++){
            stock[i] = sc.nextInt();
        }

        int jun = cash,sung = cash;
        int junNum = 0,sungNum = 0;

        for(int i = 1; i < stock.length; i++){//준현이 투자
            int buyStock = 0;

            if(jun/stock[i] > 0){//살수 있다면
                buyStock = jun/stock[i];
                jun -= stock[i]*buyStock;
            }

            junNum += buyStock;

        }


        int up = 0;
        int down = 0;
        for(int i = 2; i < stock.length; i++){//성민이 투자

            if(stock[i] > stock[i-1]){//전날보다 주가가 높을때
                up++; down = 0;
            }else if(stock[i] < stock[i-1]){//전날보다 주가가 낮을때
                down--; up = 0;
            }else{
                up = 0; down = 0;
            }

            int buyStock = 0;
            if(up >= 3){//3일 연속 가격 상승,전량 매도
                sung += stock[i]*sungNum;
                sungNum = 0;
            }else if(down <= -3){//3일 연속 가격 하락, 전량매수
                buyStock = sung/stock[i];
                sung -= stock[i]*buyStock;
                sungNum += buyStock;
            }
        }

        jun = jun + stock[14]*junNum;
        sung = sung + stock[14]*sungNum;
        //System.out.println("jun = "+jun);
        //System.out.println("sung = "+sung);

        if(jun == sung){
            System.out.println("SAMESAME");
        }else if(jun > sung){
            System.out.println("BNP");
        }else{
            System.out.println("TIMING");
        }

    }
}