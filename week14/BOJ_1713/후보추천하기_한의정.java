import java.util.*;
import java.io.*;

public class 후보추천하기_한의정 {
    static int N, M;
    static int[] students, recommend, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());  // 사진 틀 수
        M = Integer.parseInt(br.readLine());  // 추천 횟수

        List<Info> list = new ArrayList<>();    // 게시할 사진 정보 저장 리스트

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < M ; i++) {
            int student = Integer.parseInt(st.nextToken());

            if(list.size() < N) {   // 빈 사진틀이 있는 경우
                boolean flag = false;   // 게시된 사진인지 판별

                for(Info info : list) {
                    if(info.num == student) {
                        info.cnt++;
                        flag = true;
                        break;
                    }
                }

                if(!flag)
                    list.add(new Info(i, student, 1));
            }
            else {  // 빈 사진틀이 없는 경우
                Collections.sort(list);
                boolean flag = false;   // 게시된 사진인지 판별

                for(Info info : list) {
                    if(info.num == student) {   // 4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우
                        info.cnt++;
                        flag = true;
                        break;
                    }
                }

                if(!flag) { // 게시되지 않은 사진이라면, 게시된지 가장 오래된 사진 삭제하고 새로 추가함
                    list.remove(0);
                    list.add(new Info(i, student, 1));
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(Info i : list) {
            ans.add(i.num);
        }
        Collections.sort(ans);

        for(int i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static class Info implements Comparable<Info> {
        int idx, num, cnt;  // 순서, 학생 번호, 추천 수

        public Info(int idx, int num, int cnt) {
            this.idx = idx;
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Info info) {
            if(this.cnt == info.cnt)    // 추천 수가 같으면 앞쪽꺼 먼저
                return this.idx - info.idx;
            return this.cnt - info.cnt;
        }
    }
}
