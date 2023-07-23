

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        K = Integer.parseInt(stringTokenizer.nextToken());


        System.out.println(solution());
    }

    private static int solution() {
        if (N >= K) return N - K;


        int[] timeList = new int[100001];
        boolean[] visit = new boolean[100001];
        for (int i = 0; i < timeList.length; i++) {
            timeList[i] = 0;
            visit[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visit[N] = true;
        int curTime = 0;
        while (true) {
            int curPos = queue.poll();

            curTime = timeList[curPos];
            if (curPos == K) {
                return timeList[curPos];
            }

            if (curPos + 1 < 100000 && !visit[curPos + 1]) {
                queue.offer(curPos + 1);
                timeList[curPos + 1] = curTime + 1;
                visit[curPos + 1] = true;
            }
            if (curPos - 1 >= 0 && !visit[curPos - 1]) {
                queue.offer(curPos - 1);
                timeList[curPos - 1] = curTime + 1;
                visit[curPos - 1] = true;
            }
            if (curPos * 2 <= 100000 && !visit[curPos * 2]) {
                queue.offer(curPos * 2);
                timeList[curPos * 2] = curTime + 1;
                visit[curPos * 2] = true;
            }

        }
    }

}
