import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println("SK");
            return;
        }

        int[] stone = new int[N + 1];
        Arrays.fill(stone, -1);
        stone[0] = 0;
        stone[1] = 1;
        stone[2] = 0;
        int ans = game(N, stone);

        if (ans == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }

    }

    private static int game(int n, int[] stone) {

        if (n <= 0) {
            return 0;
        }

        if (stone[n] != -1) {
            return stone[n];
        }

        int result1 = game(n - 4, stone);
        int result2 = game(n - 3, stone);
        int result3 = game(n - 1, stone);

        if (result1 == 1 && result2 == 1 && result3 == 1) {
            return stone[n] = 0;
        }
        return stone[n] = 1;
    }
}
