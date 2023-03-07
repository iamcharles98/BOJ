

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N;
        int K;
        N = scanner.nextInt();
        K = scanner.nextInt();

        int Need_To_Buy = 0;
        int Sum = 0;
        int level = 1;
        int current_bottle = N;
        int max_make_bottle = N;
        while (current_bottle > K) {
            Need_To_Buy = (current_bottle % 2);
            if (can_move(current_bottle, K)) break;
            current_bottle = (current_bottle + Need_To_Buy) / 2;
            Sum += Need_To_Buy * level;
            level = level * 2;
        }

        System.out.println(Sum);
    }

    private static boolean can_move(int current_bottle,int K) {
        int bottle =0;
        while (current_bottle >1)
        {
         if(current_bottle%2==1)
         {
             bottle++;
             current_bottle= (current_bottle-1)/2;
         }
         else {
             current_bottle=current_bottle/2;
         }
        }
        bottle++;
        if(bottle<=K)return true;
        return false;

    }
}
