import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] s = new int[n];
        int[] d = new int[n];

        for(int i = 0; i < n; i++){
            s[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            d[i] = sc.nextInt();
        }

        int[] arr = new int[n];
        for(int i = 0; i < k; i++) {
            for(int j = 0; j < n; j++){
                int moveCard = s[j]; //1번째 카드는
                int index = d[j]-1; //4번째 위치로 이동해야한다

                arr[index] =  moveCard;
            }
            s = Arrays.copyOf(arr,n);
        }


        for(int i = 0; i <n; i++){
            System.out.print(arr[i]+" ");
        }



    }
}