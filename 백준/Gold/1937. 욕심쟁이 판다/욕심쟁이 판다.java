

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    n × n의 크기의 대나무 숲이 있다.
    욕심쟁이 판다는 어떤 지역에서 대나무를 먹기 시작한다.
    그리고 그 곳의 대나무를 다 먹어 치우면 상, 하, 좌, 우 중 한 곳으로 이동을 한다.
    그리고 또 그곳에서 대나무를 먹는다. 그런데 단 조건이 있다.
    이 판다는 매우 욕심이 많아서 대나무를 먹고 자리를 옮기면 그 옮긴 지역에 그 전 지역보다 대나무가 많이 있어야 한다.
    이 판다의 사육사는 이런 판다를 대나무 숲에 풀어 놓아야 하는데,
    어떤 지점에 처음에 풀어 놓아야 하고, 어떤 곳으로 이동을 시켜야 판다가 최대한 많은 칸을 방문할 수 있는지 고민에 빠져 있다.
    우리의 임무는 이 사육사를 도와주는 것이다.
    n × n 크기의 대나무 숲이 주어져 있을 때, 이 판다가 최대한 많은 칸을 이동하려면 어떤 경로를 통하여 움직여야 하는지 구하여라.

    4
    14 9 12 10
    1 11 5 4
    7 15 2 13
    6 3 16 8


    4

    각 자리를 1번씩은 방문해야함.


     */
    static int N;
    static int[][] MAP;
    static int[][] dp;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int ans = 0;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        MAP = new int[N][N];
        dp = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.println(ans);
    }

    private static int dfs(int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        dp[i][j] = 1;

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                continue;
            }
            if (MAP[i][j] < MAP[nx][ny]) {
                dp[i][j] = Math.max(dp[i][j], dfs(nx, ny) + 1);
            }
        }
        return dp[i][j];
    }
}
