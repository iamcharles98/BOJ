import java.util.*;
class Solution {
    int N;
    
    public String solution(int n, int t, int m, int p) {
        N = n;
        String allNum = makeGameNumber(m*t);
        String result = "";
        for(int turn=p-1; result.length() < t; turn+=m) {
            result += Character.toString(allNum.charAt(turn));
        }
        return result;
    }
    
    private String makeGameNumber(int size) {
        String result = "";
        int num = 0;
        while(result.length() < size) {
            result += numToStringOfN(num);
            num++;
        }
        return result.toUpperCase();
    }
    private String numToStringOfN(int number) {
        return Integer.toString(number,N);
    }
}