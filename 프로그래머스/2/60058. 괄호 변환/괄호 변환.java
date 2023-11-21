import java.util.*;
import java.lang.*;

class Solution {
    /*
    괄호 개수의 짝맞추기
    균형잡힌 문자열 + 올바른 문자열
    균형잡힌 문자열 -> 올바른 문자열로 변환
    
    1. 균형잡힌 괄호 문자열 파싱하기 -> 괄호 숫자 카운팅
    
    2. 올바른 괄호 문자열인지 체크
    
    3. 맞다면 v에 대해 1부터 다시 진행후 
    
    4. 
    
    */
    String rightString = "";
    public String solution(String p) {
        String answer = "";
        answer = step1(p);
        return answer;
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
        String empty = "(";
        empty += step1(token[1]);
        empty += ")";
        empty += removeAndReverse(token[0]);
        return empty;
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