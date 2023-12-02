import java.util.*;
import java.text.*;
import static java.util.stream.Collectors.*;

class Solution {
    /*
    셔틀 -> 09:00 부터 총 N회 t분간격, 최대 m명의 승객 탑승가능
    대기 순서대로 태우고 바로 출발
    09:00 에 도착한 셔틀 자리가 있다면 09:00에 줄을 선 크루도 탈 수 있다.
    
    어떤 크루가 몇 시에 셔틀 대기열에 도착하는지 알아냈다.
    셔틀을 타고 사무실로 갈 수 있는 도착 시간 중 제일 늦은 시각을 구하여라
    같은 시각에 도착한 크루 중 대기열에서 제일 뒤에 선다.
    
    1. 차량을 탑승할 수 있는 시간 정하기
    첫차시간 : 09:00
    회차 : n
    간격 : t
    
    2. 각 시간 별 대기 손님 정하기
    6번 예제 
    대기 라인 : 모두 23:59 <- 다 못탐 따라서 18:00에 타는 것이 정답
    즉, 셔틀버스가 도착하는 가장 늦은시간 이전 대기자만 유효한 대기자.
    09:00
    10:00
    11:00
    12:00
    13:00
    14:00
    15:00
    16:00
    17:00
    18:00
    */
    static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    static Map<Date, List<Date>> schedule;
    public String solution(int n, int t, int m, String[] timetable) throws ParseException {

        makeSchedule(n,t);
        Date date = getLateTime(timetable, m);
        
        return format.format(date);
    }
    
    public Date getLateTime(String [] timetable, int max) throws ParseException {
        List<Date> arrivalTimes = new ArrayList<>(schedule.keySet());
        List<Date> waitings = new ArrayList<>();
        for(String t : timetable) {
            waitings.add(format.parse(t));
        }
        Collections.sort(arrivalTimes);
        Collections.sort(waitings);
        
        for(Date wait : waitings) {  
            for(int i=0; i<arrivalTimes.size(); i++) {
                Date busTime = arrivalTimes.get(i);
                if(wait.compareTo(busTime) <= 0 && schedule.get(busTime).size()<max) {
                    schedule.get(busTime).add(wait);
                    break;
                }
            }
        }
        
        if(schedule.get(arrivalTimes.get(arrivalTimes.size()-1)).size()<max) {
            return arrivalTimes.get(arrivalTimes.size()-1);
        }
        else {
            Calendar cal = Calendar.getInstance();
            List<Date> last = schedule.get(arrivalTimes.get(arrivalTimes.size()-1));
            cal.setTime(last.get(last.size()-1));
            cal.add(Calendar.MINUTE, -1);
            return cal.getTime();
        }
    }
    
    public void makeSchedule(int n, int t) throws ParseException {
        schedule = new HashMap<>();
        String startTime = "09:00"; 
        Calendar cal = Calendar.getInstance();
        cal.setTime(format.parse(startTime));
        for(int i=0; i<n; i++) {
            schedule.put(cal.getTime(), new ArrayList<>());
            cal.add(Calendar.MINUTE, t);
        }
    }
    
}