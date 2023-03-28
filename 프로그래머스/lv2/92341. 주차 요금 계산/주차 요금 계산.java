import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
      int[] answer;
        HashMap<String, Integer> parking = new HashMap<>();
        HashMap<String, Integer> fee = new HashMap<>();

        for (String r : records)
        {
            String[] record = r.split(" ");
            int t = getMin(record[0]);
            String n = record[1];
            String io = record[2];

            if(io.equals("IN"))
            {
                parking.put(n, t);
            }
            else
            {
                if(!fee.containsKey(n))
                {
                    fee.put(n, t - parking.get(n));
                }
                else
                {
                    fee.put(n, fee.get(n) + t - parking.get(n));
                }
                parking.remove(n);
            }
        }


        for (String key : parking.keySet()) {
            if(!fee.containsKey(key)) {
                fee.put(key, (23*60+59)-parking.get(key));
            }else {
                fee.put(key, (23*60+59)-parking.get(key)+fee.get(key));
            }
        }


        Map<String, Integer> sortedFee = new TreeMap<>(fee);


        answer = new int[fee.size()];
        int i = 0;
        for (String car : sortedFee.keySet()) {
            int min = sortedFee.get(car);

            if(min<=fees[0]) {
                answer[i++] = fees[1];
            }else {
                answer[i++] = (int) (fees[1] + Math.ceil((double)(min-fees[0])/fees[2])*fees[3]) ;
            }
        }
        return answer;
    }

    public static int getMin(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }
}
