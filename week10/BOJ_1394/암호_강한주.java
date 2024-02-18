import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int MOD = 900528;
    static Code[] codes; //암호로 사용할 수 있는 문자들
    static String computerCode;//맞춰야 하는 암호

    static void process() {
        long ans = 0; //총 시도횟수
        for(int i = 0; i < computerCode.length(); i++) {
            //computerCode의 각 문자에 대해, 해당 문자가 codes 배열에서 어디에 위치하는지 찾아내서 암호화 과정을 진행한다.
            ans = (ans * codes.length + findStr(computerCode.substring(i,i+1))) % MOD;
        }
        System.out.println(ans % MOD);
    }

    static int findStr(String str) {//문자 str이 codes배열에서 몇번쨰에 위치하는지 '이진탐색'을 이용해 찾아낸다
        int L = 0;// 배열의 첫번째 index
        int R = codes.length - 1; //배열의 마지막 index
        int pos = R;

        while(L <= R) {
            int mid = (L + R) / 2; //절반위치
            if(str.compareTo(codes[mid].str) < 0) {//str이 codes[mid] 보다 앞에있는 문자라면
                R = mid - 1;
                pos = R;
            }else {//codes[mid]보다 뒤에 있는 문자라면
                L = mid + 1;
            }
        }
        return codes[pos].idx; //찾은 위치를 반환한다.
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        StringBuilder sb = new StringBuilder("");

        //암호로 사용할 수 있는 문자를 입력받아 split("")해서 String 배열로 저장한다.
        String[] line = br.readLine().split("");
        codes = new Code[line.length];

        for(int i = 0; i < line.length; i++) {
            codes[i] = new Code(line[i],i+1);//문자 line[i]와 그 인덱스를 저장한다
        }

        Arrays.sort(codes);//codes 배열을 알파벳 순으로 정렬한다
        computerCode = br.readLine();

        process();
    }

    static class Code implements Comparable<Code> {
        String str; //암호 문자
        int idx; //암호 문자의 인덱스

        public Code(String str,int idx) {
            this.str = str;
            this.idx = idx;
        }

        @Override
        public int compareTo(Code c) {//Code객체의 str을 비교하여 정렬한다.
            if(!this.str.equals(c.str)) {
                //this.str이 c.str보다 알파벳 순으로 앞서면 음수 반환
                //동일하면 0 반환
                //뒤쳐지면 양수 반환
                return this.str.compareTo(c.str);
            }
            return this.idx - c.idx; //두 객체의 str이 동일하면 idx를 비교한다.
        }

        @Override
        public boolean equals(Object object) {//두 Code 객체의 str이 같은지 비교한다.
            Code code = (Code)object; //Code형으로 다운캐스팅
            if(this.str.equals(code.str)) {
                return true;
            }
            return false;
        }
    }
}
