import java.util.*;

public class 단어나누기_강한주 {

    public static String change(String word) {
        String str = "";
        for(int i = word.length()-1; i>=0; i--) {
            str += word.charAt(i);
        }

        return str;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str  = sc.next();
        List<String> list = new ArrayList<>();

        for(int i = 0; i < str.length()-3; i++) {
            for(int j = i+1; j < str.length()-2; j++) {
                for(int k = j+1; k < str.length(); k++) {
                    String fst = str.substring(0,j);
                    String sec = str.substring(j,k);
                    String trd = str.substring(k,str.length());
                    list.add(change(fst)+change(sec)+change(trd));
                    //System.out.println(change(fst)+change(sec)+change(trd));
                }
            }
        }


        Collections.sort(list);

        System.out.println(list.get(0));

    }

}