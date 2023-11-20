import java.util.*;
class Solution {
    List<Set<Character>> candidateKeys = new ArrayList<>();
    String[][] table;
    
    public int solution(String[][] relation) {
        table = relation;
        int column = relation[0].length;
        String key = "";
        for(int i=0; i<column; i++) {
            key += i;
        }
        
        for(int i=1; i<column+1; i++) {
            recur(key, new HashSet<>(), i);
        }
        
        return candidateKeys.size();
    }
    
    private void recur(String key, Set<Character> set, int depth) {
        if(depth == 0) {
            if(isUnique(set) && isMinimal(set)) {
                candidateKeys.add(set);
            }
            return;
        }
        
        for(int i=0;i<key.length(); i++) {
            Set<Character> nSet = new HashSet<>(set);
            nSet.add(key.charAt(i));
            recur(key.substring(i+1), nSet, depth-1);
        }
    }
    
    private boolean isUnique(Set<Character> set) {
        Set<String> relation = new HashSet<>();
        for(String [] column : table) {
            String state = "";
            for(Character key : set) {
                state += column[key - '0'];
            }
            if(relation.contains(state)) {
                return false;
            }
            relation.add(state);
        }
        return true;
    }
    private boolean isMinimal(Set<Character> key) {
        for(Set<Character> set : candidateKeys) {
            if(key.containsAll(set)) {
                return false;
            }
        }
        return true;
    }
}