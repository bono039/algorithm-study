import java.util.*;

class k진수에서소수개수구하기_한의정 {
    public int solution(int n, int k) {
        int answer = 0;

        String[] str = Integer.toString(n, k).split("0");   // 진수 바꾸고, 배열로 만들기

        for(String s : str) {
            if(s.equals(""))    continue;   // 빈 문자열이면 pass

            if(isPrime(Long.parseLong(s)))  // 오버플로우 방지 위해 long형으로 해야 함!
                answer++;
        }

        return answer;
    }

    // 소수인지 판별하는 메소드
    private static boolean isPrime(long num) {
        if(num < 2)    return false;

        for(int i = 2 ; i <= Math.sqrt(num) ; i++) {    // i * i <= num으로 하면 오버플로우 발생ㅠ
            if(num % i == 0)
                return false;
        }

        return true;
    }
}