import java.util.*;

class Solution {
    class History{
        Map<String, String> userMap = new HashMap<>();
        List<String> messages = new ArrayList<>();
        private final String ENTER_FORMAT = "%s-님이 들어왔습니다.";
        private final String LEAVE_FORMAT = "%s-님이 나갔습니다.";
        private final String DELIMITER = "-";
        
        public History() {};
        
        public void doEnter(String userId, String nickName) {
            userMap.put(userId, nickName);
            messages.add(String.format(ENTER_FORMAT, userId));
        }
        
        public void doLeave(String userId) {
            messages.add(String.format(LEAVE_FORMAT, userId));
        }
        
        public void doChange(String userId, String nickName) {
            userMap.put(userId, nickName);
        }
        public String getResult() {
            StringJoiner sj = new StringJoiner(DELIMITER);
            for(String msg : messages) {
                String[] token = msg.split(DELIMITER);
                sj.add(userMap.get(token[0]) + token[1]);
            }
            return sj.toString();
        }
    }
    public String[] solution(String[] record) {
        History history = new History();
        for(String reco : record) {
            String [] token = reco.split(" ");
            String action = token[0];
            String uid = token[1];
            if(token[0].equals("Enter")) {
                String nickName = token[2];
                history.doEnter(uid, nickName);
            }
            else if (token[0].equals("Change")) {
                String nickName = token[2];
                history.doChange(uid, nickName);
            }
            else {
                history.doLeave(uid);
            }
        }
        
        return history.getResult().split("-");
    }
}