import java.util.*;

class Solution {
  
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> qu = new PriorityQueue<>(Collections.reverseOrder());
        for(int work : works) {
            qu.add(work);
        }
        
        for(int i=0; i<n;i++) {
            if(qu.isEmpty()) {
                return 0;
            }
            int target = qu.poll();
            if(target != 1) {
                qu.add(target-1);
            }
        }
        
        while(!qu.isEmpty()) {
            answer += Math.pow(qu.poll(), 2);
        }
        return answer;
    }
}