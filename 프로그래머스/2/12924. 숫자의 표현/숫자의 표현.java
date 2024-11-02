import java.util.*;

class Solution {
    
    static int count = 0;
    public int solution(int n) {
        
        for(int i=1; i<=n/2; i++) {
            recur(i, 0, n);
        }
        return count+1;
    }
    
    
    private void recur(int startNum, int sum, int findNum) {
        if(sum == findNum) {
            count ++;
            return;
        }
        
        if(sum > findNum) {
            return;
        }
        
        recur(startNum+1, sum+startNum, findNum);
    }
}