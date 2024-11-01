import java.util.*;

class Solution {
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!s.equals("1")) {
            char[] sequence = s.toCharArray();
            int zeroCount = 0;
            for(char bi : sequence) {
                if(bi=='0') {
                    zeroCount++;
                }
            }
            
            s = binaryOf(sequence.length - zeroCount);
            answer[1] += zeroCount;
            answer[0]++;
        }
        return answer;
    }
    
    private String binaryOf(int len) {
        String result = "";
        while(len>0) {
            result = Integer.toString(len%2) + result;
            len /= 2;
        }
        return result;
    }
}