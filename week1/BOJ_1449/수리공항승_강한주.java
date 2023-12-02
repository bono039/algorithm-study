import java.util.*;
public class 수리공항승_강한주 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int length = sc.nextInt();
        int[] pipe = new int[1001];

        for(int i = 0; i < num; i++) {
            int leak = sc.nextInt();
            pipe[leak] = 1;
        }


        for(int i = 0; i < 1001; i++) {
            if(pipe[i]==1) {
                for(int j = 0; j < length; j++) {
                    if(i+j < pipe.length)pipe[i+j] = 2; //이부분땜에 오래걸림 , 40분
                }
            }

        }

        int count = 0;
        for(int i = 0; i<1001; i++) {
            if(pipe[i]==2)count++;
        }

        if(count%length==0) {
            System.out.println(count/length);
        }else {
            System.out.println(count/length+1);
        }



    }

}