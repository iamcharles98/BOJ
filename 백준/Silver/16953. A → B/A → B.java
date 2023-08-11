

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Long B;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Long A = Long.parseLong(stringTokenizer.nextToken());
        B = Long.parseLong(stringTokenizer.nextToken());

        bfs(A);

        min = min == Integer.MAX_VALUE ? -1 : min + 1;
        System.out.print(min);
    }

    private static void bfs(Long a) {

        Set<Long> visitNum = new HashSet<>();
        Queue<Long> queue = new LinkedList<>();
        queue.add(a);
        int operationCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Long curNUm = queue.poll();
                visitNum.add(curNUm);
                if (curNUm.longValue() == B.longValue()) {
                    min = Math.min(min, operationCount);
                    break;
                }
                Long newNum1 = op1(curNUm);
                Long newNum2 = op2(curNUm);
                if (!visitNum.contains(newNum1) && newNum1 <= B) {
                    queue.offer(newNum1);
                }
                if (!visitNum.contains(newNum2) && newNum2 <= B) {
                    queue.offer(newNum2);
                }
            }
            operationCount++;

        }
    }

    private static Long op1(Long a) {
        return a * 2;
    }

    private static Long op2(Long a) {
        return a * 10 + 1;
    }

}
