import java.util.*;
class Solution {
    /*
    참여자 -> participant
    완주자 -> completion
    참여자들 중 완주자에 이름이 없는 사람 -> 완주하지 못한 사람
    주의사항 -> 동명이인이 있을 수 있음 -> 하나씩 제거해야함
    해쉬 맵 <이름, 사람 수> 
    completion 순회하면서 count--
    count 0이 아닌 이름 리턴
    */
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> board = new HashMap<>();
        for(String name : participant) {
            if(board.containsKey(name)) {
                //동명 이인
                board.put(name,board.get(name)+1);
                continue;
            }
            board.put(name,1);
        }
        for(String completeName : completion ) {
            board.put(completeName,board.get(completeName)-1);
        }
        for(String name : board.keySet()) {
            if(board.get(name)!=0) {
                answer = name;
            }
        }
        return answer;
    }
}