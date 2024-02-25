import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> words = new ArrayList<>();

        String str = br.readLine();
        int len = str.length();

        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                String str1 = str.substring(0, i + 1); //이거 i로 범위 설정해서 틀림
                String str2 = str.substring(i + 1, j + 1);
                String str3 = str.substring(j + 1, len);
                String reversed = new StringBuilder(str1).reverse().toString() +
                    new StringBuilder(str2).reverse().toString() +
                    new StringBuilder(str3).reverse().toString();
                words.add(reversed);
            }
        }

        Collections.sort(words);
        System.out.println(words.get(0));
    }
}
