import java.util.*;

public class Main {
    static char[][] arr;
    static char[][] checked;
    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {1,1,0,-1,-1,-1,0,1};
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new char[n][n];
        checked = new char[n][n];

        for(int i = 0; i < n; i++){//지뢰 표시
            String line = sc.next();

            for(int j = 0; j < n; j++){
                arr[i][j] = line.charAt(j);
            }

        }

        for(int i = 0; i < n; i++){//내가 고르기
            String line = sc.next();
            for(int j = 0; j < n; j++){
                checked[i][j] = line.charAt(j);
            }
        }

        char[][] answer = new char[n][n];
        boolean flag = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(checked[i][j] == 'x' && arr[i][j] == '.'){//뽑았는데 지뢰가 없다면
                    answer[i][j] = insertNumber(i,j);

                }else if(checked[i][j] == 'x' && arr[i][j] == '*'){//뽑았는데 지뢰가 있다면
                    flag = true;
                    //System.exit(0);
                }else{
                    answer[i][j] = '.';
                }
            }
        }

        if(flag){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(arr[i][j] == '*')answer[i][j] = '*';
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }

    }

    static char insertNumber(int i,int j){
        int count = 0;

        for(int n = 0; n < 8; n++){
            int moveX = i + dx[n];
            int moveY = j + dy[n];
            if(isValid(moveX,moveY)&&arr[moveX][moveY]=='*'){//주변에 지뢰가 있다면
                count++;
            }
        }
        return (char)(count+'0');
    }

    static boolean isValid(int x, int y){
        return x>=0 && x<n && y>=0 && y<n;
    }

}