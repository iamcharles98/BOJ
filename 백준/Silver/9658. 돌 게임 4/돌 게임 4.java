import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        //dp[i] => 상근이 턴에 i개의 돌이 남앗을때 이기는 사람 (0 -> 상근, 1 -> 창영)

        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            if(dp[i-1] + dp[i-3] + dp[i-4] > 0) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }

        if (dp[N] == 0) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }


}
