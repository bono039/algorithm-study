import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Meet implements Comparable<Meet> {

    int start;
    int end;

    public Meet(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meet o) {
        if (this.end > o.end) {
            return 1;
        } else if (this.end < o.end) {
            return -1;
        } else {
            return this.start - o.start;
        }
    }
}

public class Main {

    private int a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        List<Meet> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Meet meet = new Meet(start, end);
            meetings.add(meet);
        }

        Collections.sort(meetings);

        int end = 0;
        for (int i = 0; i < n; i++) {
            if (end <= meetings.get(i).start) {
                end = meetings.get(i).end;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
