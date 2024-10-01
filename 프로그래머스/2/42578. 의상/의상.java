import java.util.*;

class Solution {
    
    static Map<String, Integer> closet = new HashMap<>();
    
    static int answer= 1;
    
    public int solution(String[][] clothes) {
        
        fillCloset(clothes);
        
        for(String type : closet.keySet()) {
            answer *= closet.get(type) + 1;    
        }
        
        return answer-1;
    }
    
    private void fillCloset(String[][] clothes) {
        for(int i=0; i<clothes.length; i++) {
            String key = clothes[i][1];
            closet.put(key, closet.getOrDefault(key, 0) +1);
        }
    }
}