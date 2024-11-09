import java.util.*;

class Solution {
    /*
    재귀적으로 압축을 시도
    압축이 된 영역에 대해서는 더 시도하지 않음.
    1. 먼저 주어진 영역에 대해서 압축이 가능한지 확인
    2. 가능하지 않고, 주어진 영역의 크기가 1보다 크다면 영역의 1/4에 대해서 다시 검증
    3. 가능하다면 
    */
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
        if(size==1) {
            if(arr[row][col] == 1) {
                one++;
                return;
            }
            zero++;
            return;
        }
        
       if(canComp(row, col, size, arr)) {
           System.out.println(row + " " + col + " " + size);
           if(arr[row][col] == 1) {
                one++;
                return;
            }
            zero++;
            return;
       } else {
           int padding = size/2;
           doQuad(row, col, size/2, arr);
           doQuad(row, col+padding, size/2, arr);
           doQuad(row+padding, col, size/2, arr);
           doQuad(row+padding, col+padding, size/2, arr);
       }
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