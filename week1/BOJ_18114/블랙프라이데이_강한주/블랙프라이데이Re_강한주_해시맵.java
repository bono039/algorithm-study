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
        int[] arr = new int[n];

        HashSet<Integer> hs = new HashSet<>(); //HashSet는 contains를 사용하기 위한 도구일 뿐이다.
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int weight = Integer.parseInt(st.nextToken());
            arr[i] = weight;
            hs.add(weight);

            if(weight == c) {//처음에 입력받을 때 무게 c가 나오면 바로 return한다
                System.out.println(1);
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            int remain = c - arr[i]; //i번째 물건을 뽑고 남은 무게
            if(arr[i] == remain) continue; //만약 남은 무게가 arr[i]와 같다면 arr[i]를 더 뽑을 수 없으므로 continue;
            if(hs.contains(remain)) {//만약 hashSet에 remain 무게가 남아있으면 바로 return
                System.out.println(1);
                return;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int remain = c - (arr[i] + arr[j]); //arr[i],arr[j] 두개의 무게를 빼고 남은 무게 remain
                if(remain == arr[i] || remain == arr[j]) continue; //만약 remain이 뽑은 두 물건과 같다면 어차피 중복 물건은 못뽑으므로 continue
                if(hs.contains(remain)) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(0);
    }
}