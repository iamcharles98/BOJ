import java.util.*;

class Solution {
 
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i=0; i<numbers.length; i++) {
            long num = numbers[i];
            answer[i] = find(Long.toBinaryString(num).toCharArray());
            
        }
        return answer;
    }
    
    private long find(char [] binaryArray) {

        char [] padded = new char[binaryArray.length+1];
        padded[0] = '0';
        for(int i=1;i<padded.length; i++) {
            padded[i] = binaryArray[i-1];
        }
        
        for(int i=padded.length-1; i>=0; i--) {
            if(padded[i]=='0') {
                if(i==padded.length-1) {
                    padded[i]='1';
                    break;
                } else {
                    padded[i]='1';
                    padded[i+1]='0';
                    break;
                }
            }
        }
        return Long.parseLong(String.valueOf(padded),2);
        
    }
}