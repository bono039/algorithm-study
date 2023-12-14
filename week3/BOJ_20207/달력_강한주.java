import java.util.*;


public class Main {
    static class Schedule implements Comparable<Schedule>{
        int start;
        int end;

        public Schedule(int s,int e){
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Schedule o1) {
            if(this.start > o1.start )return 1;
            else if(this.start < o1.start)return -1;
            else return this.end - o1.end;
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[][] cal = new boolean[1000][366];

        List<Schedule> list = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            list.add(new Schedule(s,e));
        }

        Collections.sort(list);

        for(int i = 0; i < n; i++){
            int start = list.get(i).start;
            int end = list.get(i).end;

            for(int j = 0; j < 1000; j++){
                boolean isTrue = true;
                for(int k = start; k<= end; k++){
                    if(cal[j][k] != false){
                        isTrue = false;
                        break;
                    }
                }

                if(isTrue){
                    for(int k = start; k<= end; k++){
                        cal[j][k] = true;
                    }
                    break;
                }
            }
        }

        int[] height = new int[366];//index가 0~365일때 각 높이를 저장
        //높이 계산하기
        for(int i = 1; i <= 365; i++) {
            int max = 0;
            for(int j = 0; j < 1000; j++){
                if(cal[j][i])
                    max = Math.max(j+1,max);
            }
            height[i] = max;
        }

        //코팅하기
        int ans = 0;
        int w = 0, h = 0;
        for(int i = 1; i <= 365; i++){
            if(height[i] == 0){//i일날 높이가 0이라면
                ans += w*h;//높이가 0이면 일정이 없다는 뜻이다. 따라서 지금까지의 w,h로 직사각형 면적을 계산한다
                w = 0;
                h = 0;
            }else{//i일날 높이가 있다면
                w++;//높이가 있다는 뜻은 일정이 있다는 뜻, 즉 가로길이++
                h = Math.max(height[i],h);//지금까지 가장 높은 높이
            }
        }

        if(height[365]!=0) //마지막날 일정이 차 있는 경우 지금까지의 직사각형 넓이를 더해야한다.
            ans += w*h;

        System.out.println(ans);
    }
}