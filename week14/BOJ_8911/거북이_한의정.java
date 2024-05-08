import java.io.*;

public class 거북이_한의정 {
    static int[] dx = {0, -1, 0, 1};    // 북서남동
    static int[] dy = {1, 0, -1, 0};

    static int T;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            move(br.readLine().toCharArray());
        }

        System.out.println(sb.toString());
    }

    private static void move(char[] ch) {
        int x = 0;
        int y = 0;
        int dir = 0;    // 0 : 북
        int minX=x, minY=y, maxX=x, maxY=y;

        for(char c : ch) {
            if(c == 'F') {  // 한 눈금 앞으로
                x += dx[dir];
                y += dy[dir];
            }
            else if(c == 'B') { // 한 눈금 뒤로
                int tmpDir = (dir + 2) % 4;
                x += dx[tmpDir];
                y += dy[tmpDir];
            }
            else if(c == 'L') { // 왼쪽으로 90도 회전
                dir = (dir + 1) % 4;
            }
            else if(c == 'R') { // 오른쪽으로 90도 회전
                dir = (dir - 1 + 4) % 4;
            }

            // 최대/최소 x/y값 갱신하기
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        sb.append(Math.abs(minX - maxX) * Math.abs(minY - maxY)).append("\n");
    }
}

