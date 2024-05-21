import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        int left = 0;
        int right = 10000;
        while(left < right) {
            
            int h = (left+right)/2;
            int cnt = 0;
            for(int cite : citations) {
                if(cite >= h) {
                    cnt++;
                }
            }
            if(cnt >= h) {
                answer = h;
                left = h+1;
            } else {
                 right = h;
             }

        }
        return answer;
    }
}