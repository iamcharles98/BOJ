

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int cnt = 0;
        while (st.hasMoreTokens())
        {
            if(IsPrimev1(Integer.parseInt(st.nextToken())))
            {
                cnt ++;
            }
        }

        System.out.println(cnt);

        return;

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

