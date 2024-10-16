import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
 
    static int N;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int [] dp = Arrays.copyOfRange(arr, 0, N);
        
        for(int i = 0; i < N; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);

    }
}
