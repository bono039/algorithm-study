import java.util.Arrays;
import java.util.Scanner;

public class ATM_강한주 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] time = new int[n];

        for(int i = 0; i < time.length; i++){
            time[i] = sc.nextInt();
        }

        Arrays.sort(time);

        int prefixSum = 0;
        int sum = 0;
        for(int i = 0; i < time.length; i++){
            sum += time[i];
            prefixSum += sum;
        }

        System.out.println(prefixSum);

    }
}
