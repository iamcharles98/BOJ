import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, H;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[] sector = new int[H + 1];//  막칸여백

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                // 석순
                sector[0] += 1;
                sector[k] -= 1;
                continue;
            }

            sector[H - k] += 1;
            sector[H] -= 1;
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        int now = 0;
        
        for (int i = 0; i < sector.length - 1; i++) {
            now += sector[i];
            if (min > now) {
                min = now;
                count = 1;
            } else if(now == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}
