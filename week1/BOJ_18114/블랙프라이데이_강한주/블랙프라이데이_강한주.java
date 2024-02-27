package 블랙프라이데이_강한주;

import java.util.Arrays;
import java.util.Scanner;

public class 블랙프라이데이_강한주 {
    static int binarySearch(int[] w,int c,int low,int high){
        while(low <= high){
            int mid = (low+high)/2;

            if(w[mid] == c){
                return mid;
            }else if(w[mid] < c){
                low = mid + 1;
            }else{
                high = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] items = new int[n];

        for(int i = 0; i < n; i++){
            items[i] = sc.nextInt();
            if(items[i] == c){
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(items); //이진 탐색을 위한 정렬

        for(int i = 0; i < n; i++){
            int remain = c - items[i];
            if(binarySearch(items,remain,i+1,n-1) != -1){
                System.out.println(1);
                return;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int remain = c - items[i] - items[j];
                if(binarySearch(items,remain,j+1,n-1)!= -1){
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
