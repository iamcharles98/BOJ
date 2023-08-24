import java.util.*;
class Solution {
    /*
    어떤 번호가 다른 번호의 접두어인 경우가 있으면 false
    그렇지 않으면 true
    전화번호부 길이 -> 백만
    서치 범위를 줄여야하는데 1로 시작하는 번호는 1로 시작하는 번호들 사이에서만 서치해야함
    0 ~ 9 까지 시작번호를 key로 전화번호들을 value로 하는 Map
    */
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Integer> map = new HashMap<>();
        int cnt =0;
        for(String num : phone_book) {
            map.put(num,cnt++);
        }
        
        for(String num : phone_book) {
            for(int i=0;i<num.length();i++) {
                if(map.containsKey(num.substring(0,i))) {
                    return false;
                }
            }
        }
        return answer;
        /*Map<Character, List<String>> map = new HashMap<>();
        // 전화번호 map 생성 //
        for(int i=0;i<=9;i++) {
            map.put((char)(i+'0'),new ArrayList<>());
        }
        
        // 첫글자를 key로 전화번호부를 map에 넣을 것//
        for(String number : phone_book) {
            List<String> curList = map.get(number.charAt(0));
            //등록 된 번호가 없으면 추가 //
            if(curList.isEmpty()) {
                curList.add(number);
                continue;
            }
            //등록 된 번호가 있으면 접두사가 되는 번호가 있는지 확인 //
            for(String bookNumber : curList) {
                boolean flag = bookNumber.length() < number.length() ? number.startsWith(bookNumber) : bookNumber.startsWith(number);
                if(flag) {
                    return false;
                }
            }
            curList.add(number);
        }*/
    }
}