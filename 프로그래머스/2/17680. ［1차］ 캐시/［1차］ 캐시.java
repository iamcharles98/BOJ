import java.util.*;

class Solution {
    int limit;
    final int hitTime = 1;
    final int missTime = 5;
    LinkedList<String> cache = new LinkedList<>();
    public int solution(int cacheSize, String[] cities) {
        limit = cacheSize;
        if(limit == 0) {
            return missTime * cities.length;
        }
        int answer = 0;
        for(String city : cities) {
            String lowerCaseData = city.toLowerCase();
            if(isHit(lowerCaseData)) {
                answer += hitTime;
                continue;
            }
            LRU(lowerCaseData);
            answer+=missTime;
        }
        return answer;
    }
    
    private boolean isHit(String data) {
        if(cache.contains(data)) {
            cache.remove(data);
            cache.addFirst(data);
            return true;
        }
        return false;
    }
    private void LRU(String data) {
        if(cache.size() != 0 && cache.size() == limit) {
            cache.removeLast();
        }
        cache.addFirst(data);
        return;
    }
}