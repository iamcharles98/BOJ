import java.util.*;

class Solution {
    static class TruckInfo {
        int remainDist;
        int weight;
        
        public TruckInfo(int remainDist, int weight) {
            this.remainDist = remainDist;
            this.weight = weight;
        }
        
        public void move() {
            this.remainDist--;
        }
        
        public boolean isPass() {
            return this.remainDist<=0;
        }
    }
    
    static Queue<TruckInfo> onBoard = new LinkedList<>();
    static int seconds = 0;
    static int curWeight = 0;
    
    public int solution(int bridge_length, int weight, int[] trucks) {
        Queue<Integer> wait = new LinkedList<>();
        for(int t : trucks) {
            wait.add(t);
        }
        
        while(!wait.isEmpty() || !onBoard.isEmpty()) {
            
            for(TruckInfo ti : onBoard) {
                ti.move();
            }
            
            if(!onBoard.isEmpty() && onBoard.peek().isPass()) {
                curWeight -= onBoard.poll().weight;
            }
            
            if(!wait.isEmpty() && onBoard.size() < bridge_length && curWeight + wait.peek() <= weight) {
                onBoard.add(new TruckInfo(bridge_length, wait.peek()));
                curWeight += wait.poll();
            }
            
            seconds++;
            
        }
        return seconds;
    }
}