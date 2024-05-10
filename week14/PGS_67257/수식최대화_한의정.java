import java.util.*;

class 수식최대화_한의정 {
    static char[] operands = {'+', '-', '*'};
    static boolean[] chk = new boolean[3];

    static List<Long> numList = new ArrayList<>();  // 숫자 리스트
    static List<Character> operList = new ArrayList<>();    // 연산자 리스트

    static long answer = 0;

    public long solution(String expression) {
        String tmp = "";    // 숫자

        for(char c : expression.toCharArray()) {
            if(Character.isDigit(c)) {
                tmp += c;
            }
            else {
                numList.add(Long.parseLong(tmp));
                tmp = "";
                operList.add(c);
            }
        }
        numList.add(Long.parseLong(tmp));	// 마지막 숫자 추가

        makeCombinations(0, "");    // 순열 만들기
        return answer;
    }

    private static void makeCombinations(int cnt, String str) {
        if(cnt == 3) {  // 3개일 때 연산
            solve(str);
            return;
        }

        for(int i = 0 ; i < 3 ; i++) {
            if(!chk[i]) {
                chk[i] = true;
                makeCombinations(cnt + 1, str + operands[i]);
                chk[i] = false;
            }
        }
    }

    private static void solve(String str) {
        // 원본 숫자 리스트와 연산자 리스트 복사
        List<Long> copyNums = new LinkedList<>();
        List<Character> copyOps = new LinkedList<>();

        copyNums.addAll(numList);
        copyOps.addAll(operList);

        for(int i = 0 ; i < str.length() ; i++) {
            char nowOp = str.charAt(i); // 현재 연산자

            for(int j = 0 ; j < copyOps.size() ; j++) {
                if(copyOps.get(j) == nowOp) {   // 현재 연산자와 일치한다면, 연산
                    long res = calc(copyNums.get(j), copyNums.get(j + 1), nowOp);

                    // 현재 위치의 연산자 양 옆의 숫자와 연산자 삭제
                    copyNums.remove(j + 1);
                    copyNums.remove(j);
                    copyOps.remove(j);

                    copyNums.add(j, res);   // j 위치에 연산한 값 넣기
                    j--;
                }
            }
        }

        // 마지막 남은 숫자 하나랑 정답 비교해 더 큰 값으로 정답 갱신
        answer = Math.max(answer, Math.abs(copyNums.get(0)));
    }

    // 연산 메소드
    private static long calc(Long a, Long b, char c) {
        long result = 0;

        switch(c) {
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
        }

        return result;
    }
}