import java.util.*;

class Solution {
    /*
    2N명
    A팀, B팀
    각 사원 한번씩 경기
    라운드 마다 서로의 수를 공개
    더 큰 쪽 승리 -> 승점 1점
    A팀의 출전순서를 보고 가장 승점을 많이 얻을 수 있는 방법으로 B팀이 출전 순서를 정한다
    최장 길이 -> 100,000
    그리디한 방법으로 생각해보면
    Ai에 대해서 Ai보다 큰 원소 중 가장 작은 것을 선택하면 됨
    이길 수 있는 원소가 없다면 ? 가장 작은 원소 
    */
    
    public int solution(int[] A, int[] B) {
        int answer = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : B) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(int target : A) {
            
            if(map.higherKey(target)!=null) {
                answer++;
                if(map.get(map.higherKey(target))==1) {
                    map.remove(map.higherKey(target));
                    continue;
                }
                map.put(map.higherKey(target), map.get(map.higherKey(target))-1);
            } else {
                if(map.get(map.firstKey()) == 1) {
                    map.remove(map.firstKey());
                    continue;
                }
                map.put(map.firstKey(), map.get(map.firstKey()) - 1);
            }
        }
        
        return answer;
    }
}