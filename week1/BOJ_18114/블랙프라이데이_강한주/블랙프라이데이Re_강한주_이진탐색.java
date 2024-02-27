import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] items = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());

            if(items[i] == c) {//1개의 물건을 택했을 때 무게 c를 만족하면 바로 return
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(items); //이진 탐색을 위한 정렬

        for(int i = 0; i < n; i++) {
            int remain = c - items[i];
            if(binarySearch(items,remain,i+1,n-1) != -1) {//이진 탐색을 이용해 c를 만족하는 경우를 찾았다면
                System.out.println(1);
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int remain = c - items[i] - items[j];
                if(binarySearch(items,remain,j + 1, n - 1) != -1) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    static int binarySearch(int[] weight,int c,int low,int high) {
        while(low <= high) { //low와 high가 서로 반전되지 않을때까지 반복문을 실행한다.
            int mid = (low + high) / 2;

            if(weight[mid] == c) {
                return mid;
            }else if(weight[mid] < c) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return -1; //c를 만족하는 무게를 못찾으면 return -1;
    }

}