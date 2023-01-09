

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int N;
        int total = 0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Integer [] P = new Integer[N];
        for(int i=0;i<N;i++)
        {
            int min = sc.nextInt();
            P[i]=min;
        }

        Arrays.sort(P);
        int take_time =0;
        for(int j=0;j<P.length;j++)
        {
            take_time = take_time + P[j];
            total += take_time;

        }

        System.out.println(total);

    }
}
