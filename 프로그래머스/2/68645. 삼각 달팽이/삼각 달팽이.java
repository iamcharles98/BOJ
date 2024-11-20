import java.util.*;

class Solution {
    /*
    반시계방향으로 채우기를 한다.
    
    일단 형태를 바꿔보자
    1
    2 9
    3 10 8
    4 5 6 7
    
    1
    2 12
    3 13 11
    4 14 15 10
    5 6 7 8 9
    답은 그냥 행순으로 출력하면됨
    
    아래
    오른쪽
    대각위 싸이클 반복됨 -> n번하면됨
    근데 각 단계마다 n번만해야함.
    */
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int [][] snail = new int[n][n];
        
        int moveLimit = n;
        int row = 0;
        int col = 0;
        int moveCount = 1;
        for(int i=0; i<n; i++) {
            
            switch(i%3) {
                case 0 : 
                    for(int count = moveLimit; count >0; count--) {
                        snail[row++][col]=moveCount++;
                    }
                    row--;
                    col++;
                    break;
                case 1 :
                    for(int count = moveLimit; count >0; count--) {
                        snail[row][col++]=moveCount++;
                    }
                    col-=2;
                    row--;
                    break;
                case 2 :
                    for(int count = moveLimit; count >0; count--) {
                        snail[row--][col--]=moveCount++;
                    }
                    row+=2;
                    col++;
                    break;
            }
            moveLimit--;
        }
        
        int idx = 0;
        for(int [] arr : snail) {
            for(int i=0; i<arr.length; i++) {
                if(arr[i]==0)
                    break;
                answer[idx++] = arr[i];
            }
        }
        return answer;
    }
}