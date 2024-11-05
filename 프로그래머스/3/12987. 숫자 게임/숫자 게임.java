import java.util.*;

class Solution {
   
    
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(B);
        Arrays.sort(A);
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        
        for(int i=B.length-1; i>=0; i--) {
            deque.add(B[i]);
        }
        
        for(int i=A.length-1; i>=0; i--) {
            if(A[i] >= deque.getFirst()) {
                deque.pollLast();
            } else {
                answer++;
                deque.poll();
            }
        }
        return answer;
    }
}