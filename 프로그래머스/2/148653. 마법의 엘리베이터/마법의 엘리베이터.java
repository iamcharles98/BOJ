import java.util.*;

class Solution {
    /*
    마법의 돌을 최소한으로 사용해서 원하는 층으로 이동
    현재 층 주어졌을 때 -> 0층으로 가기 위해 필요한 마법의 돌
    위치해 있는 층 + 버튼 값이 0보다 작으면 엘리베이터는 움직이지 않는다.
    그리디?
    0층에서 시작해서
    1번의 버튼을 누르면
    1층, 10층, 100층 ... 갈 수 있음
    그 중 가장 가까운 층 => 10층
    
    10에서 9, 11, 0, 20 , 110 ... 갈 수 있음
    그 중 가장 가까운 층 => 20층
    
    20에서 19, 21, 10, 31 ... 갈 수 있음
    그 중 가장 가까운 층 => 19 층
    
    
    
    
    */
    
    
    public int solution(int storey) {
        
        int answer = 0;
        int curPos = 0;
        while(curPos != storey) {
            curPos = greedyChoice(curPos, storey);
            answer ++;
        }
        return answer;
    }
    
    private int greedyChoice(int curPos, int targetPos) {
        
        int min = Math.abs(targetPos-curPos);
        int movedPos = -1;
        int value = 1;
        for(int i=1; i<=9; i++) {
            if(curPos + value >= 0 && getDistance(curPos+value, targetPos) < min) {
                movedPos = curPos+value;
                min = getDistance(curPos+value, targetPos);
            }
            
            if(curPos - value >= 0 && getDistance(curPos-value, targetPos) < min) {
                movedPos = curPos-value;
                min = getDistance(curPos-value, targetPos);
            }
            
            value*=10;
        }
        
        return movedPos;
    }
    
    private int getDistance(int from, int to) {
        return Math.abs(from-to);
    }
}