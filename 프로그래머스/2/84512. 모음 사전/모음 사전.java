import java.util.*;

class Solution {
    static String [] OPTION = {"A", "E", "I", "O", "U"};
    static int num = 0;
    static Map<String, Integer> combinations = new HashMap<>();
    public int solution(String word) {
        
        recur("");
        
        return combinations.get(word);
    }
    
    private void recur(String combi) {
        if(combi.length() == 6) {
            return;
        }
        combinations.put(combi, num++);
        
        for(int i=0; i<5; i++) {
            String nCombi = combi+OPTION[i];
            recur(nCombi);
            nCombi = combi;
        }
    }
    
    
}