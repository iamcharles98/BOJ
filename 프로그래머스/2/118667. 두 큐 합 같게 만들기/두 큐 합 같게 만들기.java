import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long halfSum = (sum1 + sum2) / 2;
        
        int front_q1 = 0;
        int rear_q1 = queue1.length;
        int front_q2 = 0;
        int rear_q2 = queue2.length;
        int [] copy_queue1 = new int[queue1.length * 3];
        int [] copy_queue2 = new int[queue2.length * 3];
        
        for(int i=0;i<queue1.length; i++) {
            copy_queue1[i] = queue1[i];
            copy_queue2[i] = queue2[i];
        }
        
        while(sum1 != halfSum) {
            
            if(sum1 > halfSum) {
                sum1 -= copy_queue1[front_q1];
                copy_queue2[rear_q2++] = copy_queue1[front_q1];
                copy_queue1[front_q1++] = 0;
            }
            else {
                sum1 += copy_queue2[front_q2];
                copy_queue1[rear_q1++] = copy_queue2[front_q2];
                copy_queue2[front_q2++] = 0;
            }
            count ++;
            if(rear_q1 >= copy_queue1.length || rear_q2 >= copy_queue2.length) {
                return -1;
            }
        }
        return count;
    }
}