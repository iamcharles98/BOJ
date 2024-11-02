import java.util.*;

class Solution {
 
    public int solution(int n) {
        
        int baseCount = binaryOneCount(n);
        int answer = n+1;
        
        while(binaryOneCount(answer) != baseCount) {
            answer++;
        }
        
        return answer;
    }
    
    private int binaryOneCount(int num) {
        int count = 0;
        while(num > 0) {
            if(num%2==1) {
                count ++;
            }
            num/=2;
        }
        
        return count;
    }
}