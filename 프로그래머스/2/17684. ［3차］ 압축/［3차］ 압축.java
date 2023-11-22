import java.util.*;
class Solution {
    Map<String, Integer> dictionary = new HashMap<>();
    int idx = 1;
    public List<Integer> solution(String msg) {
        List<Integer> answer= new ArrayList<>();
        init();
        
        while(true) {
            String w = findLongest(msg);
            answer.add(dictionary.get(w));
            msg = msg.substring(w.length(), msg.length());
            if(!msg.equals("")) {
                dictionary.put(w+Character.toString(msg.charAt(0)),idx++);
            }
            else {
                break;
            }
        }
        return answer;
    }
    private String findLongest(String input) {
        String w = "";
        for(String key : dictionary.keySet()) {
            if(input.startsWith(key)) {
                if(key.length() > w.length()) {
                    w= key;
                }
            }
        }
        return w;
    }
    private void init() {
        for(char c = 'A'; c <='Z'; c++) {
            dictionary.put(Character.toString(c), idx++);
        }
    }
}