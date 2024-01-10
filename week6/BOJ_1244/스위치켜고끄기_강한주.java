import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int switchNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        switchNum = Integer.parseInt(st.nextToken());
        int[] switchSts = new int[switchNum+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < switchNum+1; i++){
            switchSts[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(st.nextToken());
        int[][] info = new int[student][2];

        for(int i = 0; i < student; i++){
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < student; i++){
            if(info[i][0]==1){//성별이 남자
                int num = info[i][1];//뽑은 숫자

                for(int j = 1; j<=switchNum; j++){
                    if(j%num != 0)continue;//뽑은 수의 배수가 아니라면 pass한다
                    if(switchSts[j]==0){//스위치가 꺼져있다면
                        switchSts[j]=1;//킨다
                    }else{
                        switchSts[j]=0;
                    }
                }

            }else{//성별이 여자
                int num = info[i][1];//뽑은 숫자
                int cnt = 1;

                while(true){
                    int left = num-cnt;
                    int right = num+cnt;
                    if(!isValid(left,right) || switchSts[left]!=switchSts[right]){
                        //범위를 벗어나거나 조건에 맞지 않으면
                        break;
                    }

                    if(switchSts[left]==0 && switchSts[right]==0){//둘다 꺼져있다면
                        switchSts[left] = 1;//킨다
                        switchSts[right] = 1;
                    }else{
                        switchSts[left] = 0;
                        switchSts[right] = 0;
                    }
                    cnt++;

                }
                if(switchSts[num]==0)switchSts[num] = 1;
                else switchSts[num] = 0;
            }
        }

        for(int i = 1; i<= switchNum; i++){
            System.out.print(switchSts[i]);
            if(i%20==0) System.out.println();
            else System.out.print(" ");

        }
    }

    public static boolean isValid(int left,int right){
        return (left>0 && right>0) && (left<=switchNum && right<=switchNum);
    }
}