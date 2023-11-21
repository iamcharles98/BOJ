import java.util.*;

class Solution {
    /*
    캐시 크기에 따른 실행시간 측정 프로그램
    캐시 크기 / 도시이름 배열
    캐시사이즈 -> 정수 <= 30
    도시 -> 최대 100,000개
    
    조건
    cache hit -> 실행시간 1
    cache miss -> 실행시간 5
    알고리즘 LRU
    지워져야 하는 데이터를 추적할 필요
    지워져야 하는 데이터 -> 가장 안쓰인 데이터
    */
    int limit;
    int hitTime = 1;
    int missTime = 5;
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