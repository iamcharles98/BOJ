import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] box = new int[101][101];

        for (int i = 0; i <= 100; i++) {
            Arrays.fill(box[i], -1);
        }

        if (N > M) {
            N += M;
            M = N - M;
            N -= M;
        }

        if(recursion(N,M,box)==1) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }

    }

    private static int recursion(int n, int m, int[][] box) {
        if (n == 0 || m == 0 || n > m) {
            return 0;
        }
        if (n == 1 && m == 1) {
            return 2;
        }

        if (box[n][m] != -1) {
            return box[n][m];
        }

        box[n][m] = 0;

        for (int i = 1; i <= m / 2; i++) {
            //m을 비우는 경우
            int result = recursion(i, m-i, box);

            if (result == 0 || result == 2) {
                return box[n][m] = 1;
            }
        }

        for (int i = 1; i <= n / 2; i++) {
            //n을 비우는 경우
            int result = recursion(i, n - i, box);

            if (result == 0 || result == 2) {
                return box[n][m] = 1;
            }
        }
        return box[n][m];
    }
}
