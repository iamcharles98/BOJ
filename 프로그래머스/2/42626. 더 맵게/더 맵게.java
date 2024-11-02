import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for(int s : scoville) {
            qu.add(s);
        }
        
        while(qu.size() >= 2 && qu.peek() < K) {
            int lowest = qu.poll();
            int second = qu.poll();
            qu.add(lowest + second*2);
            answer++;
        }
        
        if(qu.size()==1 && qu.peek() < K) {
            return -1;
        }
        return answer;
    }
}