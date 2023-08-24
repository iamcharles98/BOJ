import java.util.*;
class Solution {
    /*
    N마리의 포켓몬 중 N/2 가져감
    최대한 다양한 포켓몬 가져가도록 하기
    3 1 2 3 이 있으면
    3 1
    3 2
    3 3
    1 2
    1 3
    2 3 경우의 수가 있음
    이중 3 3 은 똑같은 포켓몬 2마리 가져가는 것이므로 포켓몬 수 1
    가장 많은 종류의 포켓몬을 가져가는 것은 2 따라서 2가 정답
    Set에 포켓몬 번호 등록 -> 
    */
    
    public int solution(int[] nums) {
        
        int answer = 0;
        int N = nums.length;
        Set<Integer> species = new HashSet<>();
        for(int pokemon : nums) {
            species.add(pokemon);
        }
        if(species.size()>(N/2)) {
            return N/2;
        }
        return species.size();
    }
}