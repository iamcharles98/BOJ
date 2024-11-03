import java.util.*;

class Solution {
    /*
    선행 스킬 순서
    유저들이 만든 스킬트리
    가능한 스킬트리 갯수를 세라
    
    스킬 길이 -> 26
    스킬트리 최대 갯수 20개
    각 스킬트리 최대길이 26
    
    
    방법 1.
    해쉬 맵이용
    스킬에 있는 각 알파벳의 순서를 기록
    스킬트리에 있는 각 알파벳 검사하면서 순차적으로 등장하는지 확인
    
    */
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> skillOrder = new HashMap<>();
        
        int order = 1;
        for(char s : skill.toCharArray()) {
            skillOrder.put(s, order++);
        }
        
        for(String path : skill_trees) {
            char [] step = path.toCharArray();
            int lastLearned = 0;
            boolean canLearn = true;
            for(char s : step) {
                if(!skillOrder.containsKey(s)) {
                    continue;
                }
                if(skillOrder.containsKey(s) && skillOrder.get(s) - lastLearned != 1) {
                    canLearn = false;
                    break;
                }
                lastLearned = skillOrder.get(s);
            }
            answer = canLearn ? answer+1 : answer;
        }
        return answer;
    }
}