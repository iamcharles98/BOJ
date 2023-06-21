

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bufferedReader.readLine());
        int [] nums = new int[N];

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int cnt = 0;
        while (st.hasMoreTokens())
        {
            nums[cnt++] = Integer.parseInt(st.nextToken());
        }
        cnt = IsPrimev2(nums);

        System.out.println(cnt);

        return;

    }
    public static int IsPrimev2(int [] k)
    {
        boolean [] sieve = new boolean[1001];
        for(int i =0; i< sieve.length;i++)
            sieve[i] = true;
        sieve[1] = false;
        sieve[0] = false;
        for(int i = 2; i<= Math.sqrt(1000);i++)
        {
            if(sieve[i])
            {
                for(int j = i*i; j<=1000;j+=i)
                    sieve[j] = false;
            }
        }
        int cnt = 0;
        for(int i =0;i<k.length;i++)
        {
            if (sieve[k[i]]) cnt++;
        }
        return cnt;
    }
    public static boolean IsPrimev1(int k)
    {
        if(k==1) return false;
        if(k==2) return true;

        for(int i =2; i<k;i++ )
        {
            if(k%i == 0) return false;
        }
        return true;
    }

}

