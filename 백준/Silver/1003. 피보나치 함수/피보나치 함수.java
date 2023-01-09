

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int T;
        int N;
        Map<Integer,Integer> cnt_zero= new HashMap<>();
        Map<Integer,Integer> cnt_one = new HashMap<>();
        cnt_zero.put(0,1);
        cnt_zero.put(1,0);
        cnt_one.put(0,0);
        cnt_one.put(1,1);
        T = Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<T;i++)
        {
            N = Integer.parseInt(bufferedReader.readLine());

            if(N>=2) {
                for (int j = 2; j <= N; j++) {
                    cnt_one.put(j, cnt_one.get(j - 1) + cnt_one.get(j - 2));
                    cnt_zero.put(j, cnt_zero.get(j - 1) + cnt_zero.get(j - 2));
                }
            }
            bufferedWriter.write(cnt_zero.get(N)+" "+cnt_one.get(N)+"\n");

        }
        bufferedWriter.flush();



    }
}
