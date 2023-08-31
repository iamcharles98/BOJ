import java.util.*;
class Solution {
    /*
    s와 t가 주어졌을 때
    s 가 t의 subsequence 라면 true, 아니라면 false 를 반환하시오 

    s = "abc",
    t = "ahbgdc"
    true
    
    approach #1
    s의 첫번 째 인덱스에 대해서
    t를 전체 탐색하여 일치하는 부분을 저장 idx #1 = {}
    idx #1에 대해서 하나씩 가져와 해당 인덱스 부터 t 탐색하여 두번째 인덱스 찾기 idx #2 = {}
    ... 반복해서
    idx # length of s 가 빈 배열이 아니라면 true

    시간 복잡도 : O(t.length) + O(t.length - min(idx #1) ) + O(t.length - min(idx #2)) + ... +

    t 의 subsequence 2^n 개 중 1개 찾기
    a h b g d c
    ah ab ag ad ac hb hg hd hc bg bd bc gd gc dc
    ahb ahg ahd ahc abg abd abc agd agc adc ... 
    ...
    들 중 abc가 있는지 확인 하기 위해서

        b a a b
      0 0 0 0 0
    a 0 0 1 1 1
    b 0 1 

    */
    public boolean isSubsequence(String s, String t) {
        int idx = 0;
        for(int i=0; i<t.length(); i++) {
            if(idx >=s.length()) {
                return true;
            }
            if(t.charAt(i) == s.charAt(idx)) {
                idx++;
            }
            
        }
        if(idx == s.length()) return true;
        return false;
    }
        //DP SOLUTION//
        /* 
        int [][] dp = new int [s.length()+1][t.length()+1];
    
        for(int i=1; i <=s.length() ; i++) {
            for(int j=1; j<=t.length(); j++ ) {
                if(t.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if(dp[s.length()][t.length()] == s.length()) return true;
        return false;
    } */
}
