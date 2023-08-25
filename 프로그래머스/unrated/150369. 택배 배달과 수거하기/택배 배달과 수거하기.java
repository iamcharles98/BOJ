import java.util.*;
class Solution {
    /*
    n 개의 집
    배달할 택배들 -> 물류창고에 보관되어 있음
    트럭에 실을 수 있는 택배 상자 cap 개
    배달하면서 빈 재활용 택배 상자 수거해 물류창고에 내린다.
    각 집마다 배달할 택배상자 , 수거할 택배상자 주어짐
    트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리를 구해라.
    
    1 <= cap <= 50
    1 <= n <= 100,000
    
    마지막 집부터 물류창고 방향으로 배달해야하는 갯수 더하기
    cap을 넘으면 중단하고, 출발
    cap을 넘지 않는 집 부터 마지막 집까지 배달
    돌아오면서 최대한 가득차게 빈 상자 수거
    반복
    
    한 번 갈 때 최대한 멀리 간다.
    +
    한 번 갈 때 최대한 많이 배달한다.
    +
    한 번 갈 때 최대한 많이 수거한다.
    cap -> 4
    1 0 3 0 0 
    0 3 0 4 0
    
    1 0 3 1 2
    0 3 0 4 0
    
    1 1 2 2 1
    0 0 0 0 0
    
    1 1 2 2 1
    1 1 2 2 1
    
    
     
    배달해야하는 가장 먼거리의 집 VS 수거해야하는 집 비교
    먼거리의 집부터 물류센터로 순회하면서 배달 갯수 세기
    가능한 많이 비우기
    */
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int lastVisitHome = n-1;
        while(true) {
            int farDist = getFarHome(n, deliveries, pickups, lastVisitHome);
            
            // -1 이 반환된다면 방문할 집이 없다는 뜻 //
            if(farDist == -1) {
                break;
            }
            
            // 먼거리까지 최대한 배달하기 //
            int deliverCnt = cap;
            for(int dist = farDist; dist >= 0; dist--) {
                if(deliverCnt - deliveries[dist] <= 0) {
                    deliveries[dist] -= deliverCnt;
                    deliverCnt = 0;
                    lastVisitHome = dist;
                    break;
                }
                deliverCnt -= deliveries[dist];
                deliveries[dist] =0;
            }
            
            int pickUpCnt = 0;
            //최대한 수거하기 //
            for(int dist = farDist; dist >=0; dist--) {
                if(pickUpCnt + pickups[dist] >= cap) {
                    pickups[dist] -= (cap-pickUpCnt);
                    lastVisitHome = Math.max(lastVisitHome,dist);
                    break;
                }
                pickUpCnt += pickups[dist];
                pickups[dist] = 0;
            }
            //이동 거리 추가 //
            answer += 2*(farDist+1);
        }
        return answer;
    }
    
    private static int getFarHome(int n, int [] deliveries, int [] pickups, int lastVisitHome) {
        int farDist = -1;
        for(int i=lastVisitHome;i>=0;i--) {
            if(deliveries[i]!=0 || pickups[i]!=0) {
                farDist = i;
                break;
            }
        }
        return farDist;
        
    }
}