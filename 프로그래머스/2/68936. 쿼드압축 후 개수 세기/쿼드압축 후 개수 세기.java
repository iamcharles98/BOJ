import java.util.*;

class Solution {
  
    static int zero = 0;
    static int one = 0;
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        doQuad(0, 0, arr.length, arr);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }
    
    private void doQuad(int row, int col, int size, int[][] arr) {
        
       if(canComp(row, col, size, arr)) {
           if(arr[row][col] == 1) {
                one++;
                return;
            }
            zero++;
            return;
       }
        int padding = size/2;
        doQuad(row, col, size/2, arr);
        doQuad(row, col+padding, size/2, arr);
        doQuad(row+padding, col, size/2, arr);
        doQuad(row+padding, col+padding, size/2, arr);
       
    }
    
    private boolean canComp(int row, int col, int size, int[][] arr) {
        int value = arr[row][col];
        for(int i=row; i<row+size; i++) {
            for(int j=col; j<col+size; j++) {
                if(value != arr[i][j]) {
                    return false;
                }
                value = arr[i][j];
            }
        }
        return true;
    }
}