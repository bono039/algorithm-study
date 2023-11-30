import java.util.*;
import java.io.*;

public class 단어나누기_한의정 {
    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        List<String> list = new ArrayList<>();  // 단어 저장 집합
        int len = str.length();

        for(int i = 1 ; i < len ; i++) {
            for(int j = i + 1 ; j < len ; j++) {
                String tmp = getWords(i, j);
                list.add(tmp);
            }
        }
        Collections.sort(list); // 단어 오름차순 정렬하기

        System.out.println(list.get(0));    // 사전 순 가장 앞서는 단어
    }

    private static String getWords(int s, int e) {
        StringBuilder sb = new StringBuilder();

        // 1. 문자열 3등분 쪼개기
        StringBuilder sb1 = new StringBuilder(str.substring(0, s));
        StringBuilder sb2 = new StringBuilder(str.substring(s, e));
        StringBuilder sb3 = new StringBuilder(str.substring(e));

        // 2. 쪼갠 부분 각각 뒤집고 합치기
        sb.append(sb1.reverse().toString());
        sb.append(sb2.reverse().toString());
        sb.append(sb3.reverse().toString());

        return sb.toString();
    }
}