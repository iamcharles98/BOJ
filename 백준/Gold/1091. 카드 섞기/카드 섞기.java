import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] P;
    static int[] S;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] shuffled;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        P = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] baseCase = new int[P.length];
        for (int i = 0; i < N; i++) {
            baseCase[i] = i % 3;
        }
        shuffled = Arrays.copyOf(P, P.length);
        int count = 0;
        while (!Arrays.equals(baseCase, shuffled)) {
            mix();
            count++;
            if (Arrays.equals(P, shuffled)) {
                count = -1;
                break;
            }
        }

        System.out.println(count);


    }

    public static void mix() {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[S[i]] = shuffled[i];
        }

        shuffled = arr;
    }

}
