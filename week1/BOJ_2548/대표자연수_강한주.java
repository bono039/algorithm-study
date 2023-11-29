import java.util.*;
public class 대표자연수_강한주 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        int min = Integer.MAX_VALUE;
        int ans = arr[0];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for(int i = arr.length-1; i >= 0; i--) {
            int diff = 0;

            for(int j = arr.length-1; j >= 0; j--) {

                if(i==j)continue;

                else {
                    diff += Math.abs(arr[i]-arr[j]);
                }
            }

            min = Math.min(min, diff);
            if(min == diff) {
                ans = arr[i];
            }
        }

        System.out.print(ans);

    }

}
