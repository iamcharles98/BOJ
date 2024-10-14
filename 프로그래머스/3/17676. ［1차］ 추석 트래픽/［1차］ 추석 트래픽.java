import java.util.*;

class Solution {
    static class Traffic {
        double start;
        double end;
        
        public Traffic(double start, double end) {
            this.start = start;
            this.end = end;
        } 
    }
    public int solution(String[] lines) {
        int answer = 0;
        List<Traffic> tList = new ArrayList<>();
        for(String l : lines) {
            String[] data = l.split(" ");
            
            tList.add(getTime(data[1], data[2]));
        }
        
        for(int i=0; i<tList.size(); i++) {
            double end = tList.get(i).end;
            int temp = 1;
            for(int j=i+1; j<tList.size(); j++) {
                double start = tList.get(j).start;
                if(end+999d >= start) {
                    temp++;
                } 
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }
    
    public Traffic getTime(String time, String process) {
        String[] data = time.split(":");
        process = process.replace("s","");
        double hour = Double.parseDouble(data[0])*3600d*1000d;
        double min = Double.parseDouble(data[1])*60d*1000d;
        
        double sec = Double.parseDouble(data[2]) * 1000d;
        double pTime = Double.parseDouble(process)*1000d;

        return new Traffic(hour+min+sec - pTime + 1d, hour+min+sec);
    }
}