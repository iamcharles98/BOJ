import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String p) {
        return step1(p);
    }
    
    private String step1(String p) {
        if(p.equals("")) {
            return p;
        }
        String [] token = parser(p);
        if(isRightString(token[0])) {
            token[0] += step1(token[1]);
            return token[0];
        }
        return step2(token); 
    }
    private String step2(String[] token) {
        String result = "(";
        result += step1(token[1]);
        result += ")";
        result += removeAndReverse(token[0]);
        return result;
    }
    
    private String removeAndReverse(String u) {
        if(u.length() < 3) {
            return "";
        }
        String nU = u.substring(1,u.length()-1);
        String result = "";
        for(int i=0;i<nU.length();i++) {
            if(nU.charAt(i) == '(') {
                result += ")";
            }else {
                result += "(";
            }
        }
        return result;
    }
    private String[] parser(String p) {
        String [] result = new String[2];
        int cnt = 0;
        for(int i=0; i<p.length(); i++) {
            char cur = p.charAt(i);
            if(cur == '(') {
                cnt ++;
            }
            else {
                cnt --;
            }
            if(cnt == 0) {
                cnt = i;
                break;
            }
        }
        result[0] = p.substring(0,Math.min(cnt+1,p.length()));
        result[1] = p.substring(cnt+1,p.length());
        return result;
    }
    
    private boolean isRightString(String p) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<p.length(); i++) {
            char cur = p.charAt(i);
            if(stack.isEmpty()) {
                if(cur == '(') {
                    stack.add(cur);
                }
                else {
                    return false;
                }
                continue;
            }
            char top = stack.peek();
            if(top != cur) {
                stack.pop();
                continue;
            }
            stack.add(cur);
        }
        return stack.isEmpty();
    }
}