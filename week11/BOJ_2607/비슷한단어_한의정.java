import java.io.*;

public class 비슷한단어_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) - 1;
        String first = br.readLine();

        int[] alphabet = new int[26];
        for(int i = 0 ; i < first.length() ; i++) {
            alphabet[first.charAt(i) - 'A']++;
        }

        int ans = 0;

        while(N --> 0) {
            int[] tmp = alphabet.clone();
            String word = br.readLine();

            int cnt = 0;    // 같은 단어 개수
            for(int i = 0 ; i < word.length() ; i++) {
                if(tmp[word.charAt(i) - 'A'] > 0) {
                    cnt++;
                    tmp[word.charAt(i) - 'A']--;
                }
            }

            // 기준 문자열 길이 vs 비교 문자열 길이
            // 1. 비교 문자열이 한 글자 짧을 때
            if(first.length() - 1 == word.length() && cnt == word.length()) {
                ans++;
            }
            // 2. 같거나 한 글자만 바뀐 경우
            else if(first.length() == word.length()) {
                if(cnt == first.length() || cnt == first.length() - 1)
                    ans++;
            }
            // 3. 비교 문자열이 한 글자 길 때
            else if(first.length() + 1 == word.length()) {
                if(cnt == first.length())
                    ans++;
            }
        }

        System.out.println(ans);
    }
}