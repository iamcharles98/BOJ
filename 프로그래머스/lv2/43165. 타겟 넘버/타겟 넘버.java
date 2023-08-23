import java.util.*;
class Solution {
    /*
    순서 변경 없이 더하거나 빼기 -> 타겟넘버만들기
    방법의 경우의 수 세기
    1 1 1 1 1
    + + +
        -
      - +
        -
    
    
    - + +
        -
      - +
        -
        
    n 의 갯수 -> 2 ~ 20개
    
    가장 긴 경우 2^20개 1024 * 1024 -> 약 백만 개 1초도 안걸려서 탐색가능
    */
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        answer = recur(0,numbers,target);
        return answer;

    }
    
    public static int recur(int depth,int[] numbers, int target) {
        if(depth == numbers.length) {
            // 끝까지 탐색을 마쳤다면 //
            int sum = 0;
            for(int num : numbers) {
                sum += num;
            }
            if(sum == target) {
                return 1;
            }
            return 0;
        }
 
        int [] plusArr = numbers.clone();
        int [] minusArr = numbers.clone();
        minusArr[depth] = (-1) * (minusArr[depth]);
        
        return recur(depth+1,plusArr,target) + recur(depth+1,minusArr,target);
    }
}