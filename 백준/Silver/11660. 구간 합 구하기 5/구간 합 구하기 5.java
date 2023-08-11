

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int M;

    static int[][] map;

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        dp = new int[N + 1][N + 1];
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                dp[i][j] = dp[i][j - 1] + map[i][j];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x1 = Integer.parseInt(stringTokenizer.nextToken());
            int y1 = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = Integer.parseInt(stringTokenizer.nextToken());
            int y2 = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(getSum(x1, y1, x2, y2)).append("\n");
        }

        System.out.print(stringBuilder.toString());
    }

    private static int getSum(int x1, int y1, int x2, int y2) {
        // 최대 합이 약 10억 이기 때문에, int 를 반환해도 괜찮다 //
        int sum = 0;
        for (int i = x1; i <= x2; i++) {
            sum += (dp[i][y2] - dp[i][y1-1] );
        }
        return sum;
    }
}
