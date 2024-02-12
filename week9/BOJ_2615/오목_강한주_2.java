import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//맞았지만 dirty한 코드
public class Main {
    static int[][] arr = new int[19][19];
    static int result;
    static int row;
    static int col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 19; i++) {//입력
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 19; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(arr[i][j] == 0) continue;//0인 경우 패스
                int color = arr[i][j];

                boolean findrow = findRow(i,j,color);
                boolean findcol = findCol(i,j,color);
                boolean leftdiag = findLeftDiag(i,j,color);
                boolean rightdiag = findRightDiag(i,j,color);

                if(findrow == true || findcol == true || rightdiag == true){
                    result = color;
                    row = i+1;
                    col = j+1;
                    break;
                }else if(leftdiag == true){
                    result = color;
                    row = i + 5;
                    col = j - 3;
                    break;
                }
            }
            if(result != 0)break;
        }

        System.out.println(result);
        if(result != 0){
            System.out.println(row+" "+col);
        }

    }

    static boolean findRow(int x, int y,int color){
        int plus = 1;
        int total = 1;

        while(true) {
            if(isValid(x,y + plus) && arr[x][y + plus] == color) {//색이 같다면
                total++;
                plus++;
            }else break;
        }

        plus = 1;
        while(true){
            if(isValid(x ,y - plus) && arr[x][y - plus] == color){
                total++;
                plus++;
            }else break;
        }

        if(total == 5) return true;
        else return false;
    }

    static boolean findCol(int x,int y,int color){
        int plus = 1;
        int total = 1;

        while(true) {
            if(isValid(x + plus,y) && arr[x + plus][y] == color) {//색이 같다면
                total++;
                plus++;
            }else break;
        }

        plus = 1;
        while(true){
            if(isValid(x - plus,y) && arr[x - plus][y] == color){
                total++;
                plus++;
            }else break;
        }

        if(total == 5) return true;
        else return false;
    }

    static boolean findRightDiag(int x,int y,int color){
        int plus = 1;
        int rightBelow = 1;

        while(true) {
            if(isValid(x + plus,y + plus) && arr[x + plus][y + plus] == color) {//색이 같다면
                rightBelow++;
                plus++;
            }else break;
        }

        plus = 1;
        while(true){
            if(isValid(x - plus, y - plus) && arr[x - plus][y - plus] == color){
                rightBelow++;
                plus++;
            }else break;
        }

        if(rightBelow == 5) return true;
        else return false;
    }

    static boolean findLeftDiag(int x,int y,int color){
        int plus = 1;
        int leftBelow = 1;

        while(true) {
            if(isValid(x + plus, y - plus) && arr[x + plus][y - plus] == color){
                leftBelow++;
                plus++;
            }else break;
        }

        plus = 1;
        while(true){
            if(isValid(x - plus, y + plus) && arr[x - plus][y + plus] == color){
                leftBelow++;
                plus++;
            }else break;
        }

        if(leftBelow == 5) return true;
        else return false;
    }

    static boolean isValid(int x, int y){
        return (x >= 0 && x < 19) && (y >= 0 && y < 19);
    }
}