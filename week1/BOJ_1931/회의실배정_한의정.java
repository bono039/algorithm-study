import java.util.*;
import java.io.*;

class Meeting implements Comparable<Meeting> {
    int s, e;

    public Meeting(int s, int e) {
        this.s = s;
        this.e = e;
    }

    // 종료 시간 순 오름차순 정렬
    @Override
    public int compareTo(Meeting mm) {
        // 종료시간이 다르다면, 종료 시간 순 오름차순 정렬
        if(this.e != mm.e)
            return this.e - mm.e;

        // 종료시간이 같다면, 시작 시간 순 오름차순 정렬
        return this.s - mm.s;
    }
}

public class 회의실배정_한의정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Meeting[] m = new Meeting[N];

        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            m[i] = new Meeting(s, e);
        }
        Arrays.sort(m);

        int tmpS = m[0].s;
        int tmpE = m[0].e;
        int cnt = 1;    // 첫 번째 값

        for(int i = 1 ; i < m.length ; i++) {
            if(tmpE <= m[i].s) {
                tmpS = m[i].s;
                tmpE = m[i].e;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
