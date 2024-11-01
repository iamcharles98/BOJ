import java.util.*;

class Solution
{
    /*
    
    A a b c (a<=b<=c)
    B d e f (d<=e<=f) 일 때,
    한 배열 내의 가장 큰 수 k에 대해서
    다른 배열의 가장 작은수 m과 계속 곱해야만 한다.
    
    */
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length-(i+1)];
        }

        return answer;
    }
}