import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        // id_list로 신고 횟수를 기록하는 자료구조 생성 + 유저 인덱스 기록//
        Map<String, Integer> userIdx = new HashMap<>();
        Map<String, Integer> scoreBoard = new HashMap<>();
        for(int i=0; i<id_list.length; i++) {
            scoreBoard.put(id_list[i],0);
            userIdx.put(id_list[i],i);
        }
        
        
        // report 배열을 읽어 어떤 유저가 어떤 유저를 신고했는지 기록하는 자료구조 생성 //
        Map<String, Set<String>> reportBoard = new HashMap<>();
        for(int i=0; i<report.length; i++) {
            String[] temp = report[i].split(" ");
            String reportUser = temp[0];
            String reportedUser = temp[1];
            if(reportBoard.containsKey(reportUser)) {
                reportBoard.get(reportUser).add(reportedUser);
            }
            else {
                reportBoard.put(reportUser,new HashSet<>());
                reportBoard.get(reportUser).add(reportedUser);
            }
        }
        
        Set<String> banUserSet = new HashSet<>();
        // 신고 횟수 기록하기 + 정지유저 확인 //
        for(String key : reportBoard.keySet()) {
            for(String reportedUser : reportBoard.get(key)) {
                scoreBoard.put(reportedUser,scoreBoard.get(reportedUser)+1);
                if(scoreBoard.get(reportedUser) >= k) {
                    banUserSet.add(reportedUser);
                }
            }
        }
        
        // 정지유저를 신고한 유저 확인 후 메일 갯수 업데이트 //
        for(String reportUser : reportBoard.keySet()) {
            for(String banUser : banUserSet) {
                if(reportBoard.get(reportUser).contains(banUser)) {
                    answer[userIdx.get(reportUser)] +=1;
                }
            }
        }
        return answer;
    }
}