

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    세계적인 호텔인 형택 호텔의 사장인 김형택은 이번에 수입을 조금 늘리기 위해서 홍보를 하려고 한다.
    형택이가 홍보를 할 수 있는 도시가 주어지고, 각 도시별로 홍보하는데 드는 비용과, 그 때 몇 명의 호텔 고객이 늘어나는지에 대한 정보가 있다.
    예를 들어, “어떤 도시에서 9원을 들여서 홍보하면 3명의 고객이 늘어난다.”와 같은 정보이다.
    이때, 이러한 정보에 나타난 돈에 정수배 만큼을 투자할 수 있다.
    즉, 9원을 들여서 3명의 고객, 18원을 들여서 6명의 고객, 27원을 들여서 9명의 고객을 늘어나게 할 수 있지만, 3원을 들여서 홍보해서 1명의 고객, 12원을 들여서 4명의 고객을 늘어나게 할 수는 없다.
    각 도시에는 무한 명의 잠재적인 고객이 있다. 이때, 호텔의 고객을 적어도 C명 늘이기 위해 형택이가 투자해야 하는 돈의 최솟값을 구하는 프로그램을 작성하시오.

    입력
    첫째 줄에 C와 형택이가 홍보할 수 있는 도시의 개수 N이 주어진다. C는 1,000보다 작거나 같은 자연수이고, N은 20보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에는 각 도시에서 홍보할 때 대는 비용과 그 비용으로 얻을 수 있는 고객의 수가 주어진다. 이 값은 100보다 작거나 같은 자연수이다.

    도시별 최소 홍보 비용, 홍보 했을 때의 효과는 투자한 돈의 정수배만큼 증가
    고객을 C명 늘이기 위해 투자해야하는 돈의 최솟값을 구하시오

    C N
    N개의 줄 -> 도시 홍보 비용 + 효과

    어떤 도시를 홍보할지 말지 결정 -> 같은 비용이 있을때 더 큰 홍보효과를 낼 때 선택
100 6
4 9
9 11
3 4
8 7
1 2
9 8
[(4,9) (9,11) (3,7) (8,7) (1,2) (9,8)]
   0 1 2 3 4 5 6 7 8 9... 2000
0  0 0 0 ...
1  0 0 0 0 9 9 9 9 18 18  ... 27
2  0 0 0 0 9 9 9 9 18 18
3  0 0 0 7 9 9 14 16 18 21
4  0
5  0
6  0
if(비용에 여유가 있다면)
dp[i][j] = max(dp[i][j-choices[i][0]] + choices[i][1], dp[i-1][j])
없다면
dp[i][j-1]
     */
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int C, N;
    static int[][] choices;
    static final int MAX_VALUE = 10000;

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        C = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());

        choices = new int[N + 1][2];

        for (int i = 1; i <= N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            choices[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            choices[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int[][] dp = new int[N + 1][100001];
        for (int i = 0; i <= 100000; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 100001; j++) {
                if (choices[i][0] <= j) {
                    dp[i][j] = Math.max(choices[i][1] + dp[i][j - choices[i][0]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for (int cost = 1; cost < 100001; cost++) {
            if (dp[N][cost] >= C) {
                System.out.println(cost);
                return;
            }
        }

        return;


    }
}
