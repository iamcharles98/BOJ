import java.util.*;
class Solution {
    /*
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