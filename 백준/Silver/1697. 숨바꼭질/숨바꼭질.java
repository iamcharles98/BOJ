import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int curPos;
    static int hidePos;

    static class MoveInfo {
        int pos;
        int moveCnt;

        public MoveInfo(int pos, int moveCnt) {
            this.pos = pos;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException {

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        curPos = input[0];
        hidePos = input[1];

        if (curPos >= hidePos) {
            System.out.println(curPos - hidePos);
            return;
        }

        Queue<MoveInfo> pq = new LinkedList<>();
        int minTime = hidePos - curPos;
        pq.offer(new MoveInfo(curPos, 0));
        boolean[] visit = new boolean[100001];
        while (!pq.isEmpty()) {
            MoveInfo cur = pq.poll();
            if (cur.pos > 100000 || visit[cur.pos]) {
                continue;
            }
            visit[cur.pos] = true;

            if (cur.pos >= hidePos) {
                if (minTime >= cur.moveCnt + (cur.pos - hidePos)) {
                    minTime = cur.moveCnt + (cur.pos - hidePos);
                }
                continue;
            }

            pq.offer(new MoveInfo(cur.pos + 1, cur.moveCnt + 1));
            if (cur.pos > 0) {
                pq.offer(new MoveInfo(cur.pos - 1, cur.moveCnt + 1));
                pq.offer(new MoveInfo(cur.pos * 2, cur.moveCnt + 1));
            }
        }

        System.out.println(minTime);


    }
}
