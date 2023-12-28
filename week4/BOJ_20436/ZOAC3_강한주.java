import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Axis{ //x와 y좌표를 저장하는 클래스
    int x;
    int y;
    public Axis(int x,int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static String[][] keyBoard = new String[][]
            {
                    {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"},
                    {"a", "s", "d", "f", "g", "h", "j", "k", "l"},
                    {"z", "x", "c", "v", "b", "n", "m"}
            };
    static int time = 0; //총 시간

    static int leftX; static int leftY; static int rightX; static int rightY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String sL = st.nextToken();
        String sR = st.nextToken();
        String str = br.readLine();

        leftX = getIndex(sL).x;
        leftY = getIndex(sL).y;
        rightX = getIndex(sR).x;
        rightY = getIndex(sR).y;

        for(int i = 0; i < str.length(); i++){
            String strAlpha = str.substring(i,i+1);
            int strAlphaX = getIndex(strAlpha).x;
            int strAlphaY = getIndex(strAlpha).y;

            if(strAlpha.equals("y")||strAlpha.equals("u")||strAlpha.equals("i")||strAlpha.equals("o")||strAlpha.equals("p")||strAlpha.equals("h")||
                    strAlpha.equals("j")||strAlpha.equals("k")||strAlpha.equals("l")||strAlpha.equals("b")||strAlpha.equals("n")||strAlpha.equals("m")){
                int rightDistance = getDistance(rightX,strAlphaX,rightY,strAlphaY);
                time += rightDistance;
                time++;
                rightX = strAlphaX;
                rightY = strAlphaY;
            }else{
                int leftDistance = getDistance(leftX,strAlphaX,leftY,strAlphaY);
                time += leftDistance;
                time++;
                leftX = strAlphaX;
                leftY = strAlphaY;
            }

        }

        System.out.println(time);
    }

    static int getDistance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static Axis getIndex(String alpha) {
        Axis xy = new Axis(0,0);

        for(int i = 0; i < keyBoard.length; i++){
            for(int j = 0; j < keyBoard[i].length; j++){
                if(alpha.equals(keyBoard[i][j])){
                    xy.x = i;
                    xy.y = j;
                }
            }
        }

        return xy;
    }

}