import java.util.*;

/**
괄호가 주어지면 올바른지 아닌자 확인
**/
class Solution {
    static char open = '(';
    static char close = ')';
    boolean solution(String s) {
        
        if(s.length() % 2 !=0) {
            return false;
        }
        char[] samples = s.toCharArray();
        
        Stack<Character> stack = new Stack<>();
        
        for(char sample : samples) {
            if(stack.isEmpty()) {
                stack.push(sample);
                continue;
            } 
            
            if(stack.peek() == close) {
                return false;
            }
            
            if(sample == close) {
                stack.pop();
                continue;
            }
            
            stack.push(sample);
        }

        return stack.isEmpty();
    }
}