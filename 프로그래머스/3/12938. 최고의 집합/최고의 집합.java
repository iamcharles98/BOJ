import java.util.*;

class Solution {
    
    
    public int[] solution(int n, int s) {
        
        if(s/n==0) {
            return new int[] {-1};
        }
        int[] answer = new int[n];
        int q = s/n;
        int r = s%n;
        
        for(int i=0; i<n; i++) {
            if(i >= n-r) 
                answer[i] = q+1;
            else 
                answer[i] = q;
        }
        
        return answer;
    }
    

}