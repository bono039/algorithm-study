import java.util.*;
import java.io.*;

public class ZOAC3_한의정 {
    static Keyboard[] qwerty = new Keyboard[30];

    static String pos;
    static char[] input;
    static int[] left = new int[2];     // 왼쪽 검지 위치 배열
    static int[] right = new int[2];    // 오른쪽 검지 위치 배열

    static int time = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        makeKeyboard();

        pos = br.readLine();

        for(int j = 0 ; j < 30 ; j++) {
            if(pos.charAt(0) == qwerty[j].c) {
                // 입력받은 두 문자가 무조건 (왼쪽 자판에 있는 값, 오른쪽 자판에 있는 값) 순으로 있는 게 아니므로 어느 쪽에 있는 문자인지 확인해 위치값 저장
                if(qwerty[j].hand == 'l') {
                    left = new int[] {qwerty[j].x, qwerty[j].y};
                }
                else {
                    right = new int[] {qwerty[j].x, qwerty[j].y};
                }
                break;
            }
        }
        for(int j = 0 ; j < 30 ; j++) {
            if(pos.charAt(2) == qwerty[j].c) {
                // 입력받은 두 문자가 무조건 (왼쪽 자판에 있는 값, 오른쪽 자판에 있는 값) 순으로 있는 게 아니므로 어느 쪽에 있는 문자인지 확인해 위치값 저장
                if(qwerty[j].hand == 'l') {
                    left = new int[] {qwerty[j].x, qwerty[j].y};
                }
                else {
                    right = new int[] {qwerty[j].x, qwerty[j].y};
                }
                break;
            }
        }

        input = br.readLine().toCharArray();

        for(int i = 0 ; i < input.length ; i++) {
            // 문자열 위치 찾기
            char h = 'x';
            int[] findPos = new int[2]; // 찾는 문자열의 위치 값 저장할 배열

            for(int j = 0 ; j < 30 ; j++) {
                if(input[i] == qwerty[j].c) {
                    findPos[0] = qwerty[j].x;
                    findPos[1] = qwerty[j].y;
                    h = qwerty[j].hand;
                    break;
                }
            }

            if(h == 'l') {      // 왼쪽 자판에 있는 문자인 경우
                int dist = Math.abs(left[0] - findPos[0]) + Math.abs(left[1] - findPos[1]);
                time += dist + 1;
                left = findPos; // 왼쪽 검지 위치 갱신
            }
            else if(h == 'r') { // 오른쪽 자판에 있는 문자인 경우
                int dist = Math.abs(right[0] - findPos[0]) + Math.abs(right[1] - findPos[1]);
                time += dist + 1;
                right = findPos;    // 오른쪽 검지 위치 갱신
            }
        }

        System.out.println(time);
    }

    private static void makeKeyboard() {
        qwerty[0] = new Keyboard('q', 'l', 0, 0);
        qwerty[1] = new Keyboard('w', 'l', 0, 1);
        qwerty[2] = new Keyboard('e', 'l', 0, 2);
        qwerty[3] = new Keyboard('r', 'l', 0, 3);
        qwerty[4] = new Keyboard('t', 'l', 0, 4);
        qwerty[5] = new Keyboard('y', 'r', 0, 5);
        qwerty[6] = new Keyboard('u', 'r', 0, 6);
        qwerty[7] = new Keyboard('i', 'r', 0, 7);
        qwerty[8] = new Keyboard('o', 'r', 0, 8);
        qwerty[9] = new Keyboard('p', 'r', 0, 9);

        qwerty[10] = new Keyboard('a', 'l', 1, 0);
        qwerty[11] = new Keyboard('s', 'l', 1, 1);
        qwerty[12] = new Keyboard('d', 'l', 1, 2);
        qwerty[13] = new Keyboard('f', 'l', 1, 3);
        qwerty[14] = new Keyboard('g', 'l', 1, 4);
        qwerty[15] = new Keyboard('h', 'r', 1, 5);
        qwerty[16] = new Keyboard('j', 'r', 1, 6);
        qwerty[17] = new Keyboard('k', 'r', 1, 7);
        qwerty[18] = new Keyboard('l', 'r', 1, 8);
        qwerty[19] = new Keyboard('X', 'x', 0, 0);  // null

        qwerty[20] = new Keyboard('z', 'l', 2, 0);
        qwerty[21] = new Keyboard('x', 'l', 2, 1);
        qwerty[22] = new Keyboard('c', 'l', 2, 2);
        qwerty[23] = new Keyboard('v', 'l', 2, 3);
        qwerty[24] = new Keyboard('b', 'r', 2, 4);
        qwerty[25] = new Keyboard('n', 'r', 2, 5);
        qwerty[26] = new Keyboard('m', 'r', 2, 6);

        qwerty[27] = new Keyboard('X', 'x', 0, 0);  // null
        qwerty[28] = new Keyboard('X', 'x', 0, 0);  // null
        qwerty[29] = new Keyboard('X', 'x', 0, 0);  // null
    }
}

class Keyboard {
    char c, hand;
    int x, y;

    //               키보드 문자, 어떤 손인지, 행 위치, 열 위치
    public Keyboard(char c, char hand, int x, int y) {
        this.c = c;
        this.hand = hand;
        this.x = x;
        this.y = y;
    }
}
