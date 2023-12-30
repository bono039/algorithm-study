import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> u = new LinkedList<>();
        Queue<Integer> a = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        Queue<Integer> k = new LinkedList<>();
        int ans = 0;

        List<Integer[]> quack = new ArrayList<>();//<startQIdx,lastKIdx>

        for(int i = 0; i < str.length(); i++){
            String word = str.substring(i,i+1);

            if(word.equals("q"))q.add(i);
            else if(word.equals("u"))u.add(i);
            else if(word.equals("a"))a.add(i);
            else if(word.equals("c"))c.add(i);
            else{
                k.add(i); //이거 안써서 10분 날렸다
                if(q.peek() != null && u.peek() != null && a.peek()!= null && c.peek() != null && k.peek()!= null){
                    if(!(q.peek()<u.peek()) || !(u.peek()<a.peek()) || !(a.peek()<c.peek()) || !(c.peek()<k.peek())){
                        System.out.println("-1");
                        System.exit(0);
                    }
                    int qIndex = q.poll();
                    u.poll();
                    a.poll();
                    c.poll();
                    int kIndex = k.poll();
                    quack.add(new Integer[]{qIndex,kIndex});
                }else{
                    System.out.println("-1");
                    System.exit(0);
                }
            }
        }

        if(q.size() != 0 || u.size() != 0 || a.size() != 0 || c.size() != 0 || k.size() != 0){//필수로 확인해야한다!!!!
            //quackk이나 qquackk처럼 나오면 올바르지 않다!!!!
            System.out.println("-1");
            System.exit(0);
        }


        //오리수 count
        int[] duck = new int[str.length()];
        for(int i = 0; i < quack.size(); i++){
            int start = quack.get(i)[0];
            int end = quack.get(i)[1];
            for(int j = start; j <= end; j++){
                duck[j]++;
            }
        }

        for(int i = 0; i < duck.length; i++){
            ans = Math.max(duck[i],ans);
//            System.out.print(duck[i]);
        }

        System.out.println(ans);

    }
}