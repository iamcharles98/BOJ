import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class Main {

    static int N, M;
    static int[] pos = new int[100001];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Move {
        int pos;
        int count;

        public Move(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {
        String[] strings = br.readLine().split(" ");
        N = Integer.parseInt(strings[0]);
        M = Integer.parseInt(strings[1]);

        if (M <= N) {
            System.out.println(N - M);
            return;
        }

        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(N, 0));
        Arrays.fill(pos, Integer.MAX_VALUE);

        int minTime = M - N;
        while (!queue.isEmpty()) {
            Move cur = queue.poll();

            if (cur.pos >= M) {
                minTime = Math.min(minTime, cur.count + cur.pos - M);
                continue;
            }

            if (cur.count > pos[cur.pos]) {
                continue;
            }

            pos[cur.pos] = cur.count;

            if (cur.pos != 0) {
                queue.add(new Move(cur.pos * 2, cur.count));
                queue.add(new Move(cur.pos - 1, cur.count + 1));
            }
            queue.add(new Move(cur.pos + 1, cur.count + 1));
        }

        System.out.println(minTime);

    }


}
