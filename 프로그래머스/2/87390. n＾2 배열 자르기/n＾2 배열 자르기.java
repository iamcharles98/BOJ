import java.util.*;
class Solution {
    /*
    10,000,000
    실제로 배열 만들면 죽는다잉
    
    left부터 right 까지의 각 칸에 해당하는 번호가 무엇인지 알면됨
    한 열 -> n개
     
    1 2 3
    2 2 3
    3 3 3
    
    1 2 3 2 2 3 3 3 3
    
    0 => 0행 0열
    1 => 0행 1열
    2 => 0행 2열
    3 => 1행 0열
    
    x행 y열 에 있는 숫자는 ?
    둘 중에 큰 숫자가 된다.
    k를 3으로 나눈 몫 => 행
    k를 3으로 나눈 나머지 => 열
    */
    public List<Integer> solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        
        for(long i=left; i<=right; i++) {
            answer.add(getNum(n, i));
        }
        return answer;
    }
    
    private int getNum(int size, long index) {
        long row = index/(long)size;
        long col = index%(long)size;
        
        return (int)Math.max(row, col) +1;
    }
}