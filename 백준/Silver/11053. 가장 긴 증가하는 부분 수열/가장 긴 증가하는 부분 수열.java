import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
     /*
        가장 긴 증가하는 부분 수열
        수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램
        예를 들어 {10, 20, 10, 30, 20, 50} 인 경우 가장 긴 증가하는 부분 수열 -> 10, 20, 30, 50 길이 : 4

        DP -> 이전에 구했던 해를 이용
        10 -> 길이가 1
        20 -> 길이가 2
        10 -> 이전 값들 중 10보다 작거나 같은 값에서 가장 큰 DP값 +1
        30 -> ''

     */

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[size];
        int[] dp = new int[size];
        int count = 0;
        int max = Integer.MIN_VALUE;
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        while (stringTokenizer.hasMoreTokens()) {
            arr[count] = Integer.parseInt(stringTokenizer.nextToken());
            dp[count++] = 1;
        }
        

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < i; j++) {
                // i 이전 원소 탐색 //
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            // 이전 원소 탐색 끝
            max = Math.max(max,dp[i]);
        }

        System.out.println(max);
    }


}
