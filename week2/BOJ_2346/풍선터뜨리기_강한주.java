package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> ballon = new LinkedList<>();
        Queue<Integer> paper = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){ //ballon에는 풍선번호를, papaer에는 종이에 적힌 값을 넣는다
            ballon.add(i+1);
            int num = Integer.parseInt(st.nextToken());
            paper.add(num);
        }


        for(int i = 0; i < n; i++){//총 n개의 풍선이 터저야 끝난다
            int nextNum = paper.poll();
            System.out.print(ballon.poll()+" ");

            if(nextNum > 0){//나온 숫자가 양수면 오른쪽이동
                for(int j = 0; j < nextNum-1;j++){
                    paper.add(paper.poll());
                    ballon.add(ballon.poll());
                }
            }else{
                for(int j = 0; j < paper.size()+nextNum; j++){
                    paper.add(paper.poll());
                    ballon.add(ballon.poll());
                }
            }
        }


    }
}
