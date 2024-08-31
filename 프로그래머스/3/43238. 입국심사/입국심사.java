import java.util.*;

/*
한 심사대 동시에 한 명만 심사
가장 앞에 서 있는 사람은 비어있는 심사대로 가서 심사 받을 수 있다.
가장 빠른 심사대인 7에서 4번 받을 때
10분걸리는 심사대에서 2명 받을 수 있음
그럼 알고리즘 -> 최소의 분을 찾아서 각 심사대에 해당 시간대에 최대 몇명 처리할 수 있는지
찾으면됨
근데 최대 최소는 어떻게?
단순하게 
가장 오래걸리는 심사대에서 모든 사람이 심사받는 것을 최대로 하고
최소는 1로?
*/
class Solution {
    public long solution(int n, int[] times) {
        
        long maxValue = findMaxTime(times);
        long max = maxValue * n;
        long min = 1;
        
        while(min<max) {
            long mid = (min+max)/2;
            long totalHandle = 0;
            for(int time : times) {
                totalHandle += mid/time;
            }
            
            if(totalHandle >= n) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        return min;
    }
    
    private long findMaxTime(int[] times) {
        long max = -1;
        
        for(int num : times) {
            if(max < num) {
                max = num;
            }
        }
        return max;
    }
}