

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++)
        {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }

        System.out.println((int)getAvg(list));
        System.out.println(getMid(list));
        System.out.println(getFrequentNum(list));
        System.out.println(getScope(list));

        return;
    }
    public static double getAvg(List<Integer> list)
    {
        double sum=0;
        for(int num : list)
        {
            sum += num;
        }
        sum = sum/N;
        sum = Math.round(sum);
        return sum;
    }
    public static Integer getMid(List<Integer> list)
    {
        int midIdx = N/2;
        Collections.sort(list);
        return list.get(midIdx);
    }
    public static Integer getFrequentNum(List<Integer> list)
    {

        List<Integer> FrequentNum = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : list)
        {
            if(map.containsKey(num))
            {
                int cnt = map.get(num);
                map.put(num,++cnt);
            }
            else
            {
                map.put(num,1);
            }
        }
        Collection<Integer> values = map.values();
        int Frequency = Collections.max(values);
        for(int key : map.keySet())
        {
            if(map.get(key) == Frequency)
                FrequentNum.add(key);
        }
        Collections.sort(FrequentNum);
        if(FrequentNum.size()==1)
            return FrequentNum.get(0);
        return FrequentNum.get(1);
    }
    public static Integer getScope(List<Integer> list)
    {
        int max = Collections.max(list);
        int min = Collections.min(list);
        return  max-min;
    }
}
