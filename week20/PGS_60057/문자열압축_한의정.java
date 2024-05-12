package PGS_60057;

class 문자열압축_한의정 {
    public int solution(String s) {
        int answer = s.length();
        int len = 1;    // 문자열 반복 횟수

        for(int i = 1 ; i <= s.length() / 2 ; i++) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);    // 비교 대상이 되는 앞 단어

            for(int j = i ; j <= s.length() ; j += i) {
                int eIdx = Math.min(j + i, s.length());
                String next = s.substring(j, eIdx); // 비교 대상이 되는 뒷 단어

                if(base.equals(next)) { // 이전 문자 = 현재 문자인 경우
                    len++;
                }
                else {
                    if(len >= 2) {  // 2번 이상 반복되는 경우, 반복 횟수 붙이기
                        sb.append(len);
                    }

                    sb.append(base);
                    base = next;    // 앞 단어 갱신하기
                    len = 1;        // 반복 횟수 1로 갱신하기
                }
            }

            sb.append(base);    // 마지막 단어 붙이기
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}