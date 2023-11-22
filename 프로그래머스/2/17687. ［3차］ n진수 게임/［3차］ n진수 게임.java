import java.util.*;
class Solution {
    /*
    진법 n
    튜브가 말해야할 숫자의 갯수 t
    게임 참가 인원 m
    튜브의 순서 p
    
    String 배열 m * t 개 만들어서 0 ~ 배열 끝까지 진법에 따른 숫자 한개씩 저장
    
    */
    Map<Integer, String> nStringMap = new HashMap<>();
    int N;
    public String solution(int n, int t, int m, int p) {
        N = n;
        initMap();
        String allNum = makeGameNumber(m*t);
        String result = "";
        for(int turn=p-1; turn < allNum.length() && result.length() < t; turn+=m) {
            result += Character.toString(allNum.charAt(turn));
        }
        return result;
    }
    private void initMap() {
        for(int i=0; i<16;i++) {
            nStringMap.put(i,Integer.toString(i,16).toUpperCase());
        }
    }
    private String makeGameNumber(int size) {
        String result = "";
        int num = 0;
        while(result.length() < size) {
            result += numToStringOfN(num);
            num++;
        }
        return result;
    }
    private String numToStringOfN(int number) {
        String result = "";
        if(number == 0) {
            return nStringMap.get(number);
        }
        while(number > 0) {
            result =  nStringMap.get(number % N)+ result;
            number /= N;
        }
        
        return result;
    }
}