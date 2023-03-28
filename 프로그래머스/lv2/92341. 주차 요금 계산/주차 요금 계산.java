import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer,String> In_time = new HashMap<>();
        HashMap<Integer,Integer> Price = new HashMap<>();
        for(String record : records)
        {
            String[] temp = record.split(" ");
            int car_num = Integer.parseInt(temp[1]);
            String flag = temp[2];
            if(flag.equals("IN"))
            {
                String in_time = temp[0];
                In_time.put(car_num,in_time);
                if(!Price.containsKey(car_num))Price.put(car_num,0);
            }
            else
            {
                String out_time = temp[0];
                int time = calculator2(In_time.get(car_num),out_time);
                Price.put(car_num,Price.get(car_num)+time);
                In_time.remove(car_num);

            }
        }
        if(!In_time.isEmpty())
        {
            for (Integer integer : In_time.keySet()) {
                int time = calculator2(In_time.get(integer),"23:59");
                Price.put(integer,Price.get(integer)+time);
                In_time.remove(integer);

            }
        }
        for(int i : Price.keySet())
        {
            Price.put(i,calculator(Price.get(i),fees));
        }
        int [] answer;
        List<Integer> keyset = new ArrayList<>(Price.keySet());
        answer = new int[keyset.size()];
        int cnt = 0;
        Collections.sort(keyset);
        for(int it : keyset)
        {
            answer[cnt++]=Price.get(it);
        }
        return answer;
    }
     
    private static int calculator2(String inTime, String outTime) {
        int IntimeTomin = Integer.parseInt(inTime.split(":")[0])*60 + Integer.parseInt(inTime.split(":")[1]);
        int OuttimeTomin = Integer.parseInt(outTime.split(":")[0])*60 + Integer.parseInt(outTime.split(":")[1]);
        int result = OuttimeTomin-IntimeTomin;
        return result;
    }
    
    private static int calculator(int totalTime, int[] fees) {
        int std_time = fees[0];
        int std_fee = fees[1];
        int plus_time = fees[2];
        int plus_fee = fees[3];

        int fee = std_fee;
        double value = (double) (totalTime-std_time)/(double) plus_time;
        value = Math.ceil(value);
        if(totalTime>std_time) fee =  std_fee + (int)value*plus_fee;
        return fee;
    }
}