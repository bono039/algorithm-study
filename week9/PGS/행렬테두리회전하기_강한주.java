class Solution {
    static int[][] arr;
    static int[] answer;

    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];

        initArr(rows, columns);

        for(int i = 0; i < queries.length; i++){
            int startX = queries[i][0] - 1;
            int startY = queries[i][1] - 1;
            int endX = queries[i][2] - 1;
            int endY = queries[i][3] - 1;

            rotate(startX,startY,endX,endY,i);
        }

        return answer;
    }

    public void initArr(int rows,int columns){//배열 초기화 메서드
        arr = new int[rows][columns];
        int startNum = 1;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = startNum;
                startNum++;
            }
        }
    }

    public void rotate(int startX,int startY,int endX,int endY,int idx){
        int firstNum = arr[startX][endY];//수를 저장한다 , 회전시키면 1개의 수를 필히 저장시켜야 하기 때문
        int min = firstNum;


        //숫자를 오른쪽으로 이동시킨다(상단 테두리)
        for(int i = endY - 1; i >= startY; i--){
            min = Math.min(min,arr[startX][i]);
            arr[startX][i + 1] = arr[startX][i]; //당긴다는 개념
        }

        //숫자를 위쪽으로 이동시킨다(좌측 테두리)
        for(int i = startX + 1; i <= endX; i++){
            min = Math.min(min,arr[i][startY]);
            arr[i - 1][startY] = arr[i][startY];
        }

        //숫자를 왼쪽으로 이동시킨다(하단 테두리)
        for(int i = startY + 1; i <= endY; i++){
            min = Math.min(min,arr[endX][i]);
            arr[endX][i - 1] = arr[endX][i];
        }

        //숫자를 아래로 이동(우측 테두리)
        for(int i = endX - 1; i >= startX; i--){
            min = Math.min(min,arr[i][endY]);
            arr[i + 1][endY] = arr[i][endY];
        }

        arr[startX + 1][endY] = firstNum;//처음 저장했던 수를 다시 채워준다
        answer[idx] = min;
    }
}