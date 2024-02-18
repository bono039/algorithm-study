import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder(); //마지막 string 출력을 위한 StringBUilder

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            char[] word = br.readLine().toCharArray();
            nextWord(word);
        }

        System.out.println(sb.toString());

    }

    static void nextWord(char[] word) {
        int front = -1;
        int behind = 0;

        for(int i = word.length - 1; i > 0; i--) {//단어 끝에서부터 조회
            if(word[i - 1] < word[i]) {//만약 자신의 앞 char가 뒤 char보다 작으면
                front = i - 1; //일단 앞 char의 index를 기록한다
                break;
            }
        }

        if(front == -1) {//front가 변경되지 않았다 == 주어진 단어가 마지막 단어이므로 그냥 출력하면됨
            for(int i = 0; i < word.length; i++) {
                sb.append(word[i]);
            }
            sb.append('\n'); //단어를 끝까지 입력하면 개행문자 입력
        }else {//정렬을 할 필요가 있으면
            for(int i = word.length -1 ; i >= 0; i--) {//단어의 끝에서부터 front의 char다음으로 큰 char을 찾는다
                if(word[front] < word[i]) {//발견했다면
                    behind = i; //swap해야할 index기록한다
                    break;
                }
            }

            swap(front,behind,word);

            Arrays.sort(word,front + 1, word.length); //sort에 매개변수 3개를 쓰는건 처음이다

            for(int i = 0; i < word.length; i++) {
                sb.append(word[i]);
            }

            sb.append('\n');
        }

    }

    static void swap(int front,int behind,char[] word) {
        char temp = word[front];
        word[front] = word[behind];
        word[behind] = temp;
    }
}