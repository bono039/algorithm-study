import java.util.*;
import java.io.*;

public class 마법사상어와블리자드_한의정 {
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    static int N,M;
    static int[][] map;
    static List<int[]> list = new ArrayList<>();
    static int[] cntArr = new int[3];   // 폭발한 구슬 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0 ; i < N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calcTornado();

        // 블리자드 마법
        while(M --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            destroy(d-1,s);   // 1. 구슬 파괴

            move(); // 2. 구슬 이동

            while(chkMarble())  // 3. 4개 이상 이어지는 구슬 있다면, 이동시킴
                move();

            changeMarble(); // 4. 구슬 재배치
        }

        System.out.println(cntArr[0] + 2*cntArr[1] + 3*cntArr[2]);
    }

    private static void destroy(int d, int s) {
        int r = N/2;
        int c = N/2;

        for(int i = 0 ; i < s ; i++) {
            r += dr[d];
            c += dc[d];
            map[r][c] = 0;
        }
    }

    private static void move() {
        Queue<Integer> q = new ArrayDeque<>();

        // 1 이상의 구슬 번호 가진 구슬 순서대로 저장
        for(int[] m : list) {
            if(map[m[0]][m[1]] != 0)
                q.add(map[m[0]][m[1]]);
        }

        // 구슬 전부 0으로 처리
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++)
                map[i][j] = 0;
        }

        // 다시 처음부터 저장한 구슬들 재배치
        int idx = 0;
        while(!q.isEmpty()) {
            int num = q.poll();
            map[list.get(idx)[0]][list.get(idx)[1]] = num;
            idx++;
        }
    }

    // 4개 이상 이어지는 구슬 있는지 확인
    private static boolean chkMarble() {
        Queue<int[]> tmp = new ArrayDeque<>();
        Queue<int[]> removeList = new ArrayDeque<>();

        boolean canExplode = false;
        int r = list.get(0)[0];
        int c = list.get(0)[1];
        int num = map[r][c];
        int combo = 1;

        tmp.add(new int[]{r, c});

        for(int i = 1 ; i < list.size() ; i++) {
            int nr = list.get(i)[0];
            int nc = list.get(i)[1];

            // 구슬 없으면 break
            if(map[nr][nc] == 0)    break;

            // 이전 구슬과 같으면 콤보 증가
            if(map[nr][nc] == num) {
                combo++;
                tmp.add(new int[]{nr, nc});
            }
            else {
                if(combo >= 4) {
                    canExplode = true;

                    while(!tmp.isEmpty()) {
                        removeList.add(tmp.poll());
                    }
                }

                num = map[nr][nc];
                combo = 1;
                tmp.clear();
                tmp.add(new int[]{nr, nc});
            }
        }

        // 맨 마지막에 콤보가 4 이상인 채 마무리되었을 때 처리
        if(combo >= 4) {
            canExplode = true;

            while(!tmp.isEmpty())
                removeList.add(tmp.poll());
        }

        // 제거해야 할 구슬들 좌표에 해당하는 구슬들 없애기
        while(!removeList.isEmpty()) {
            int[] now = removeList.poll();

            switch(map[now[0]][now[1]]) {
                case 1: cntArr[0]++; break;
                case 2: cntArr[1]++; break;
                case 3: cntArr[2]++; break;
            }

            map[now[0]][now[1]] = 0;
        }

        return canExplode;
    }

    // 구슬들 재배치
    private static void changeMarble() {
        Queue<int[]> q = new ArrayDeque<>();

        int num = map[list.get(0)[0]][list.get(0)[1]];
        int combo = 1;

        // 이어지는 구슬들이 번호가 같은지 확인
        for(int i = 1 ; i < list.size() ; i++) {
            int nr = list.get(i)[0];
            int nc = list.get(i)[1];

            // 0 만나면 break
            if(map[nr][nc] == 0) {
                if(num != 0)
                    q.add(new int[] {combo, num});
                break;
            }

            if(map[nr][nc] == num)
                combo++;
            else {
                q.add(new int[] {combo, num});
                num = map[nr][nc];
                combo = 1;
            }
        }

        if(q.size() == 0 && combo == 1) {
            if(num != 0)
                q.add(new int[] {combo, num});
        }

        // 맵 전체 구슬 0으로 초기화
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++)
                map[i][j] = 0;
        }

        // 큐에 담은 콤보와 구슬번호로 map 재배치
        for(int i = 0 ; i < list.size() ; i += 2) {
            int[] tmp1 = list.get(i);
            int[] tmp2 = list.get(i+1);

            int nr1 = tmp1[0];
            int nc1 = tmp1[1];

            int nr2 = tmp2[0];
            int nc2 = tmp2[1];

            if(q.size() == 0)   break;

            int[] tmp = q.poll();
            int tmpCombo = tmp[0];
            int tmpNum = tmp[1];

            map[nr1][nc1] = tmpCombo;
            map[nr2][nc2] = tmpNum;
        }
    }

    private static void calcTornado() {
        int[] tr = {0,1,0,-1};    // 위, 오, 아, 왼
        int[] tc = {-1,0,1,0};

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {N/2, N/2, 0, 0});

        int cnt = 0;

        while(true) {
            int[] tmp = q.poll();
            int r = tmp[0];
            int c = tmp[1];
            int dir = tmp[2];
            int cycle = tmp[3];

            if(cnt % 2 == 0)
                cycle++;
            cnt++;

            for(int i = 0 ; i < cycle ; i++) {
                int nr = r + tr[dir];
                int nc = c + tc[dir];

                list.add(new int[] {nr, nc});

                if(nr == 0 && nc == 0)  return;

                r = nr;
                c = nc;
            }

            dir = (dir + 1) % 4;
            q.add(new int[] {r, c, dir, cycle});
        }
    }
}
