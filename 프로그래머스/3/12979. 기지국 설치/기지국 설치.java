import java.util.*;

class Solution {
    /*
    전파의 도달거리 w -> 기지국 위치가 k라고 할때, 전파 도달 범위 => k-w <= range <= k+w
    모든 아파트에 전파를 전달하기 위해 최소로 증설해야 하는 기지국 개수
    N => 최대 2억
    station -> 오름차순 정렬
    
    1. 전파가 도달되지 않는 구간을 찾기
    2. 각 구간을 모두 커버하기 위해 필요한 최소 기지국 갯수 -> 나머지가 없을 때까지 전파도달범위로 나눈 횟수?
    */
    static int coverage;
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int first = 1;
        coverage = w*2 + 1;
        
        for(int station : stations) {
            int last = station-w-1;
            if(first <= last) {
                int range = last-first + 1;
            
                int needStation = range / coverage;
                int remain = range % coverage;
            
            answer =  remain == 0 ? answer + needStation : answer + needStation + 1;
                
            }
            first = station + w + 1;
          
        }
        
        if(first<=n) {
            int range = n - first + 1;
            int needStation = range / coverage;
            int remain = range % coverage;
            answer =  remain == 0 ? answer + needStation : answer + needStation + 1;
        }

        return answer;
    }
}