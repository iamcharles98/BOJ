import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int goToChannel;
    static int N;
    static int CURRENT = 100;
    static int minClickCnt = Integer.MAX_VALUE;
    static Set<Integer> banned = new HashSet<>();

    public static void main(String[] args) throws IOException {

        goToChannel = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        if (N != 0) {
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(i -> banned.add(i));
        }
        if (goToChannel == CURRENT) {
            System.out.println(0);
            return;
        }
        minClickCnt = Math.abs(goToChannel - CURRENT);

        recur("");

        System.out.println(minClickCnt);
    }

    private static void recur(String channel) {
        if (channel.length() > 6) {
            return;
        }
        if (!channel.isEmpty()) {
            int dist = calcDist(channel) + channel.length();
            if (dist < minClickCnt) {
                minClickCnt = dist;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (banned.contains(i)) {
                continue;
            }
            String nChannel = channel + i;
            recur(nChannel);
        }
    }

    private static Integer calcDist(String channel) {
        return Math.abs(Integer.parseInt(channel) - goToChannel);
    }
}
