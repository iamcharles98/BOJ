import java.util.*;

class Solution {
    static class Route implements Comparable<Route> {
        int from;
        int to;
        
        public Route(int f, int t) {
            this.from = f;
            this.to = t;
        }
        
        public int compareTo(Route r) {
            return this.to - r.to;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<Route> routeList = new PriorityQueue<>();
        
        for(int [] route : routes) {
            routeList.add(new Route(route[0], route[1]));
        }
        
        int lastPos = -30001;
        while(!routeList.isEmpty()) {
            Route r = routeList.poll();
            
            if(r.from > lastPos) {
                lastPos = r.to;
                answer++;
            }
        }
        
        return answer;
    }
}