import java.util.*;

class Solution {
    /*
    택배기사 배달 순서, 택배상자 실려있는 순서 다르면 안됨
    택배 기사가 알려준 순서에 맞게 택배 상자를 실어야한다.
    보조 컨테이너 벨트 -> 맨 앞의 상자만 뺄 수 있다.(가장 마지막에 보관한 상자부터 꺼내게 된다.)
    보조 컨테이너 벨트 -> 스택이고
    기존 컨테이너 벨트 -> 큐
    
    1. 기존 컨테이너 벨트에서 상자 확인
    2. 기사님 순서와 같다면 상차
    3. 기사님 순서와 다르다면 보조 컨테이너 벨트 확인
    4. 보조 컨테이너 벨트 맨 앞 상자가 기사님 순서와 같다면 상차
    5. 다르다면 보조 컨테이너 벨트에 기존 컨테이너 벨트 상자 상차
    6. 기사님 순서와 기존 컨테이너 벨트 + 보조 컨테이너 벨트 모두 다르다면 진행 불가.
    
    상차 종료 조건
    1. 기존 컨테이너 벨트, 보조 컨테이너 벨트 모두 다 상차한 경우
    2. 기사님이 원하는 순서와 기존, 보조 컨테이너 벨트의 앞 상자가 일치하지 않는 경우
    */
    
    static Stack<Integer> subBelt = new Stack<>();
    static int mainBelt = 1;
    static int idx = 0;
    public int solution(int[] order) {
        int answer = 0;
        while(mainBelt < order.length || !subBelt.isEmpty()) {
            
            if(mainBelt == order[idx]) {
                answer ++;
                idx++;
                mainBelt++;
                continue;
            }
            
            if(!subBelt.isEmpty() && subBelt.peek()==order[idx]) {
                answer++;
                idx++;
                subBelt.pop();
                continue;
            }
            
            if(mainBelt >= order.length) {
                break;
            }
            
            subBelt.push(mainBelt++);
        }
        return answer;
    }
    
    
    
}