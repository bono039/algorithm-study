import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<String> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(br.readLine());
        }


        int[] dna = new int[4];
        int hamDis = 0;
        ArrayList<Character> answer = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char c = arr.get(j).charAt(i);
                if(c == 'A'){
                    dna[0]++;
                }else if(c == 'C'){
                    dna[1]++;
                }else if(c == 'G'){
                    dna[2]++;
                }else if(c == 'T'){
                    dna[3]++;
                }
            }

            int max = -1;
            int index = 0;
            for(int j = 0; j < 4; j++){
                if(dna[j] > max){
                    max = dna[j];
                    index = j;
                }
            }

            if(index == 0){
                answer.add('A');
            }else if(index == 1){
                answer.add('C');
            }else if(index == 2){
                answer.add('G');
            }else{
                answer.add('T');
            }
            Arrays.fill(dna,0);
        }

        for(int i = 0; i < m; i++){
            char c = answer.get(i);
            System.out.print(c);
            for(int j = 0; j < n; j++){
                if(c != arr.get(j).charAt(i)){
                    hamDis++;
                }
            }
        }

        System.out.println();
        System.out.println(hamDis);

    }
}