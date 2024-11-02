import java.util.*;

class Solution {
    /*
    begin -> target으로 규칙에 따라 변환할 때, 가장 짧은 변화 과정을 찾는다.
    begin에서 하나의 알파벳만 변경할 수 있는데, words에 있는 단어여야한다.
    
    1. 현재 상태에서 바꿀 수 있는 단어를 찾는다. (방문처리)
    2. target과 비교한다.
    
    일단 target 단어가 항상 words에 있어야 변환이 가능하다.
    
    */
    static int min = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) {
        
        transition(0, new HashSet<>(), begin, target, words);
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    private void transition(int count, Set<String> visit, String cur, String target, String[] words) {
        if(cur.equals(target)) {
            min = Math.min(min, count);
            return;
        }
        
        for(String candi : words) {
            if(isChangable(cur, candi) && !visit.contains(candi)) {
                Set<String> nVisit = new HashSet(visit);
                nVisit.add(candi);
                transition(count+1, nVisit, candi, target, words);
            }
        }
    }
    private boolean isChangable(String cur, String target) {
        int count = 0;
        for(int i=0; i<cur.length(); i++) {
            if(cur.charAt(i) != target.charAt(i)) {
                count++;
            }
        }
        return count==1;
    }
}