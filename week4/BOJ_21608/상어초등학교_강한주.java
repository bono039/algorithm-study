import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


public class Main {
    static int n;
    static int[][] arr;
    static HashMap<Integer,Integer[]> hashMap = new HashMap<>();
    static int[] dx = {0,1,0,-1}; //동남서북
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i = 0; i <n*n; i++){
            st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());
            int likeStudent1 = Integer.parseInt(st.nextToken());
            int likeStudent2 = Integer.parseInt(st.nextToken());
            int likeStudent3 = Integer.parseInt(st.nextToken());
            int likeStudent4 = Integer.parseInt(st.nextToken());

            //해시맵에 학생번호와 좋아하는 학생4명을 저장한다
            hashMap.put(studentNum,new Integer[]{likeStudent1,likeStudent2,likeStudent3,likeStudent4});

            //현재 학생의 자리를 구한다
            putStudent(studentNum);
        }


        //만족도 조사
        int sum = 0;
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n; j++){
                int count = 0;
                Integer[] friends = hashMap.get(arr[i][j]);//arr에 적혀있는 학생의 친한 친구 4명을 배열에 넣는다

                for(int k = 0; k < 4; k++){
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n)continue;

                    for(int p = 0; p<4; p++) {
                        if(arr[nextX][nextY]==friends[p])count++;
                    }
                }

                switch(count){
                    case 0: sum += 0; break;
                    case 1: sum += 1; break;
                    case 2: sum += 10; break;
                    case 3: sum += 100; break;
                    case 4: sum += 1000; break;
                }

            }
        }

        System.out.println(sum);


    }

    static void putStudent(int studentNum){
        //좋아하는 학생4명을 꺼내 배열로 넣는다
        Integer[] friends = hashMap.get(studentNum);
        int f1 = friends[0];
        int f2 = friends[1];
        int f3 = friends[2];
        int f4 = friends[3];

        ArrayList<Integer[]> list = new ArrayList<>();
        for(int i =0 ; i < n; i++){
            for(int j = 0; j < n; j++){
                int friendsCount = 0;
                int emptyCount = 0;

                for(int k = 0; k < 4; k++){//인접한 4방향을 탐색한다
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if(nextY < 0 || nextX < 0 || nextY >= n || nextX >= n)continue;

                    if(arr[nextX][nextY]==f1 || arr[nextX][nextY]==f2 || arr[nextX][nextY]==f3 || arr[nextX][nextY]==f4){
                        friendsCount++;
                    }
                    if (arr[nextX][nextY] == 0) {
                        emptyCount++;
                    }
                }
                list.add(new Integer[]{friendsCount,emptyCount,i,j});
            }
        }

        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Integer[] n1, Integer[] n2) {
                if(n1[0] < n2[0]) return 1; //friendsCount 비교 내림차순
                else if(n1[0] == n2[0]){
                    if(n1[1] < n2[1])return 1; //emptyCount 비교 내림차순
                    else if(n1[1] == n2[1]){
                        if(n1[2] > n2[2]) return 1; //행 비교 오름차순
                        else if(n1[2] == n2[2]){
                            if(n1[3] > n2[3]) return 1;//열 비교 오름차순
                        }
                    }
                }
                return -1;
            }
        });

        //정렬된 list에서 index 0부터 시작해 arr의 해당 좌표가 0이면 그 좌표가 현재 학생의 자리다.
        for(int i = 0; i < list.size(); i++ ){//lise.size() == n*n
            int x = list.get(i)[2];
            int y = list.get(i)[3];
            if(arr[x][y] == 0){
                arr[x][y] = studentNum;
                return;
            }
        }

    }
}
