class 괄호변환_한의정 {
    public String solution(String p) {
        if(isValid(p))
            return p;
        return solve(p);
    }

    // 올바른 괄호 문자열인지 판단하는 메소드
    private static boolean isValid(String str) {
        int cnt = 0;

        for(char c : str.toCharArray()) {
            if(c == '(') {
                cnt++;
            }
            else {
                cnt--;

                if(cnt < 0)
                    return false;
            }
        }

        return true;
    }

    // 균형잡힌 괄호 문자열 -> 올바른 괄호 문자열 변환 메소드
    private static String solve(String w) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열 반환
        if(w.length() == 0) return "";

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int openCnt = 0;    // 열린 괄호 갯수

        for(int i = 0 ; i < w.length() ; i++) {
            if(w.charAt(i) == '(')  openCnt++;
            else                    openCnt--;

            if(openCnt == 0) {  // 균형잡힌 괄호 문자열인 경우
                // 2. 문자열 w를 균형잡힌 괄호 문자열 u와 v로 분리
                u.append(w.substring(0, i+1));
                v.append(w.substring(i+1));

                if(isValid(u.toString())) { // 3. 문자열 u가 올바른 괄호 문자열인 경우
                    u.append(solve(v.toString()));
                }
                else {  // 4. 문자열 u가 올바른 괄호 문자열이 아닌 경우
                    StringBuilder tmp = new StringBuilder();

                    tmp.append("(");
                    tmp.append(solve(v.toString()));
                    tmp.append(")");
                    tmp.append(reverse(u.toString()));

                    return tmp.toString();  // 4-5. 생성된 문자열 반환
                }

                break;
            }
        }

        return u.toString();    // u가 올바른 괄호 문자열인 경우에만 도달
    }

    // 괄호 방향 뒤집는 메소드
    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < str.length() - 1 ; i++) {
            sb.append(str.charAt(i) == '(' ? ')' : '(');
        }
        return sb.toString();
    }
}