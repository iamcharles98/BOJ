import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] foods;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());
        foods = new int[N];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < foods.length; i++) {
            foods[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        findMaxEnergy();

        System.out.println(answer);
    }

    private static void findMaxEnergy() {
        int beforeEnd = 0;
        int beforeEnergy = -1;
        for (int curStart = 0; curStart < foods.length; curStart++) {
            int curEnd = curStart;
            int curSum = 0;
            while (curSum < K && curEnd < foods.length) {
                curSum += foods[curEnd++];
            }
            int curEnergy = curSum - K;
            if (curEnergy > beforeEnergy && curStart <= beforeEnd) {
                beforeEnd = curEnd - 1;
                beforeEnergy = curEnergy;
            }
            if (curStart > beforeEnd) {
                answer += beforeEnergy;
                beforeEnd = curEnd - 1;
                beforeEnergy = curEnergy;
            }
        }
        answer += beforeEnergy;
    }

}
