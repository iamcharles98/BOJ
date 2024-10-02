import java.util.*;

class Solution {
    
    static class Calculator {
        int defaultTime;
        int defaultFee;
        int unitTime;
        int unitFee;
        
        public Calculator(int [] info) {
            this.defaultTime = info[0];
            this.defaultFee = info[1];
            this.unitTime = info[2];
            this.unitFee = info[3];
        }
        
        public int getFee(int minute) {
            if(minute<= defaultTime) {
                return defaultFee;
            }
            return defaultFee + (int)Math.ceil((double)(minute-defaultTime) / (double)unitTime) *unitFee;
        }
    }
    
    static Map<Integer, List<Integer>> history = new HashMap<>();
    
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Calculator calculator = new Calculator(fees);
        
        for(String r : records) {
            String [] data = r.split(" ");
            int carNum = Integer.parseInt(data[1]);
            if(!history.containsKey(carNum)) {
                history.put(carNum, new ArrayList<>());
            }
            
            String [] clock = data[0].split(":");
            history.get(carNum).add(timeToMin(Integer.parseInt(clock[0]), Integer.parseInt(clock[1])));
        }
        
        List<Integer> cars = new ArrayList<>(history.keySet());
        Collections.sort(cars);
        
        for(int car : cars) {
        
            
            if(history.get(car).size()%2 != 0) {
                history.get(car).add(timeToMin(23,59));
            }
            
            
            int i = 0;
            int totalTime = 0;
            while(i<history.get(car).size()) {
                int in = history.get(car).get(i++);
                int out = history.get(car).get(i++);
                totalTime += (out-in);
            }
            
            answer.add(calculator.getFee(totalTime));
            
        }
        
        return answer;
    }
    
    public int timeToMin(int hour, int min) {
        return hour*60 + min;
    }
}