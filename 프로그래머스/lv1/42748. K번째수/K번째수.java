import java.util.*;

class Solution {
    /*
    i 부터 j 까지 자르고 정렬 후 k 번째에 있는 수 구하기
    
    주어진 부분만 정렬해서 반환하는 함수
    
    
    */
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int [commands.length];
        
        for(int i=0; i<commands.length; i++) {
            int start, end, k;
            start = commands[i][0]-1;
            end = commands[i][1]-1;
            k = commands[i][2]-1;
            int [] sort = sortedArray(start, end , array);
            answer[i] = sort[k];
        }
        return answer;
    }
    
    private static int[] sortedArray(int start, int end, int[] array) {
        int [] sort = new int[end-start+1];

        for(int i=start; i<=end; i++) {
            sort[i-start] = array[i];
        }
        
        Arrays.sort(sort);
        return sort;
    }
    
    
}