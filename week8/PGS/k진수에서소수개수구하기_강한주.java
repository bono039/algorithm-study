import java.util.ArrayList;

class Solution {
    static ArrayList<String> arr = new ArrayList<>();
    static int answer;
    public int solution(int n, int k) {
        change(n,k);
//        Collections.reverse(arr); reverse를 굳이 안써도 된다

        String str = "";
        for(int i = arr.size() - 1; i >= 0; i--){
            str += arr.get(i); //이렇게 string을 더하는건 비효율적이지 않을까?..
        }

        divide(str);

        return answer;
    }

    public void change(int n, int k){//k진수로 바꾸는 메서드
        if(n < k){//종료조건
            arr.add(Integer.toString(n));
            return;
        }

        int r = n % k;
        arr.add(Integer.toString(r));
        change(n / k, k);
    }

    public boolean getDecimal(long num){//소수인지 확인하는 메서드
        if(num == 1){
            return false;
        }

        for(int i = 2; i <= Math.sqrt(num); i++){//Math.sqrt()를 기억하자. Math.pow()랑 헷갈렸다.
            if(num % i == 0){
                return false;
            }
        }

        return true; //소수가 맞다
    }

    public void divide(String num){
        int start = 0;

        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '0'){
                String number = num.substring(start,i); //substring 할때 위치를 기억하기 위한 변수
                start = i + 1;

                if(number.equals(""))continue;
                long getNumber = Long.parseLong(number);

                if(getDecimal(getNumber)){
                    answer++;
                }
            }else if(i == num.length() - 1){ //이 중복코드도 줄여도 될 것 같은데 찾아봐야 겠다.
                String number = num.substring(start,i+1);

                if(getDecimal(Long.parseLong(number))){
                    answer++;
                }
            }
        }
    }

}