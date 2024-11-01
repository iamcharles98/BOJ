import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] words = s.toCharArray();
        if(words.length==0) {
            return s;
        }
        
        for(int i=1; i<words.length; i++) {
            if(words[i-1] == ' ') {
                words[i] = Character.toUpperCase(words[i]);
            }else {
                words[i] = Character.toLowerCase(words[i]);
            }
        }
        
        words[0] = Character.toUpperCase(words[0]);
        
        return String.valueOf(words);
    }
    
    private String toJaden(String word) {
        
        if(word.length() < 1) {
            return word;
        }
    
        String first = word.substring(0,1);
        String remain = word.substring(1,word.length());
        
        return first.toUpperCase() + remain.toLowerCase();
        
    }
    
    
}