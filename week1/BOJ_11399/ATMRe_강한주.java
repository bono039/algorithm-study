import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
 void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int sum = 0;
    int prev = 0;
    int n = Integer.parseInt(br.readLine());
    List<Integer> p = new ArrayList<>();

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      int min = Integer.parseInt(st.nextToken());
      p.add(min);
    }

    Collections.sort(p);

    for(int i = 0; i < n; i++) {
      sum += p.get(i) + prev;
      prev += p.get(i);
    }

    System.out.println(sum);

  }
}