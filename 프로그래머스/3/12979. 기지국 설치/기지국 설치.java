import java.util.*;

class Solution {

    static int coverage;
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int first = 1;
        coverage = w*2 + 1;
        
        for(int station : stations) {
            int last = station-w-1;
            if(first <= last) {
                answer += getNeedStation(first, last);   
            }
            first = station + w + 1;
          
        }
        
        if(first<=n) {
            answer += getNeedStation(first, n);
        }

        return answer;
    }
    
    private int getNeedStation(int from, int to) {
        int range = to-from + 1;
        int needStation = range / coverage;
        int remain = range % coverage;
        return remain == 0 ? needStation : needStation + 1;
    }
}