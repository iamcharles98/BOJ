import java.util.*;
class Solution {
    static final int YEARTODAY = 28*12;
    static final int MONTHTODAY = 28;
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        // 약관을 맵으로 저장하기 //
        Map<String, Integer> rules = new HashMap<>();
        for(int i=0;i<terms.length;i++) {
            StringTokenizer term = new StringTokenizer(terms[i]," ");
            rules.put(term.nextToken(),Integer.parseInt(term.nextToken()));
        }
        
        
        // today의 value 값 계산하기 //
        String [] todayArray = today.split("\\.");
        int tYear = Integer.parseInt(todayArray[0]);
        int tMonth = Integer.parseInt(todayArray[1]);
        int tDay = Integer.parseInt(todayArray[2]);
        int todayValue = 0;
        todayValue = (tYear * YEARTODAY) + (tMonth * MONTHTODAY) + tDay;
        
        // 약관에 따라 폐기할지 안할지 결정하기 //
        for(int i=0; i<privacies.length;i++) {
            int endDayValue = getEndDate(rules,privacies[i]);
            if(isEnded(todayValue,endDayValue)) {
                answer.add(i+1);
            }
        }
        
        return answer;
    }
    
    public static boolean isEnded(int todayValue, int endDayValue) {
        return todayValue >= endDayValue;
    }
    
    public static int getEndDate(Map<String, Integer> terms, String privacy) {
        String [] privacyArray = privacy.split(" ");
        String date = privacyArray[0];
        String rule = privacyArray[1];
        int addDate = terms.get(rule) * MONTHTODAY;
        String [] endDateArray = date.split("\\.");
        int eYear = Integer.parseInt(endDateArray[0]);
        int eMonth = Integer.parseInt(endDateArray[1]);
        int eDay = Integer.parseInt(endDateArray[2]);
        int endDayValue = 0;
        endDayValue = (eYear * YEARTODAY) + (eMonth * MONTHTODAY) + eDay + addDate;
        return endDayValue;
    }
}

