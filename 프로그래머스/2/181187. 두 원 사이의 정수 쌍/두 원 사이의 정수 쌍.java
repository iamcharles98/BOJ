import java.util.*;
import java.math.*;

class Solution {
    /*
    큰 원의 반지름을 R, 작은 원의 반지름을 r이라고 할 때
    
    y좌표를 0 부터 R까지 반복한다.
    y = yk 인 직선과 원 C1, C2 가 만나는 접점의 x좌표를 구해서 그 사이의 길이의 정수 구하기
    */
 
    static int bigRadius;
    static int smallRadius;
    
    public long solution(int r1, int r2) {
        long answer = 0;
        
        // 4개의 사분면 중 1개만 구한뒤 4를 곱한다.
        for( int i = 1; i <= r2 ; i++){
            double y2 = Math.sqrt(Math.pow(r2,2) - Math.pow(i,2));
            double y1 = Math.sqrt(Math.pow(r1,2) - Math.pow(i,2));
            answer += ( (long)y2 - (long)Math.ceil(y1) + 1);
        }
        answer *= 4;
        
        return answer;
    }
  
    private void setBigRadius(int r1, int r2) {
        if(r1 > r2) {
           bigRadius = r1;
           smallRadius = r2;
        }
        else {
           bigRadius = r2;
           smallRadius = r1;
        }
    }
    private long getCountOfBetweenPoint(int x) {
        
        double bigY = Math.sqrt((bigRadius*bigRadius) - (x*x));
       
        double smallY = Math.sqrt((smallRadius*smallRadius) - (x*x));
       
        return ((long)bigY - (long)Math.ceil(smallY) + 1L);
    }
    
}