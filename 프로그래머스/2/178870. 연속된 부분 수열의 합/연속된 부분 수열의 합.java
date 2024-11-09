import java.util.*;
class Solution {
    /*
    연속된 부분수열 합 => 누적합을 통해 O(1)로 구할 수 있음
    
    0 1 3 6 10 15
    0 1 2 3 5 8 12 17
    */
    static int min = Integer.MAX_VALUE;
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int [2];
        int [] sum = new int[sequence.length+1];
        int i=1;
        for(int num : sequence) {
            sum[i] = sum[i-1] + num;
            i++;
        }
        int left = 0;
        int right = 1;
        while(right<sum.length) {
            if(sum[right] - sum[left] == k) {
                if(right-left < min) {
                    min = right-left;
                    answer[0] = left;
                    answer[1] = right-1;
                }
                right++;
                continue;
            } else if(sum[right] - sum[left] > k) {
                left++;
            } else {
                right++;
            }
        }
        
        return answer;
    }
}