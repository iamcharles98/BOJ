import java.util.*;
class Solution {
    
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        Set<String> set1 = new HashSet<>();
        for(int len = 0 ; len<s1.length; len++) {
            set1.add(s1[len]);
        }
        for(int len = 0 ; len<s2.length; len++) {
            if(!set1.add(s2[len])){
                answer++;
            }
        }
        return answer;
    }
}