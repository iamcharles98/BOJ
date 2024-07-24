import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
   
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] colorCost;
    static int[][] dp;

    public static void main(String[] args) {
        try {
            N = Integer.parseInt(bufferedReader.readLine());
            dp = new int[N + 1][3];
            colorCost = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                colorCost[i] = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt)
                        .toArray();
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            dp[1] = Arrays.copyOf(colorCost[1], colorCost[1].length);

            for (int i = 2; i <= N; i++) {
                for (int j = 0; j < 3; j++) {
                    int curCost = colorCost[i][j];
                    for (int k = 0; k < 3; k++) {
                        if (k != j) {
                            dp[i][j] = Math.min(dp[i][j], curCost + dp[i - 1][k]);
                        }
                    }
                }
            }

            Arrays.sort(dp[N]);
            System.out.println(dp[N][0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
