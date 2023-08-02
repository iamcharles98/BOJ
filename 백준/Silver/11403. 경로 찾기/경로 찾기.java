

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Integer N;
    static Integer[][] output;
    static Integer[][] input;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        output = new Integer[N][N];
        input = new Integer[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                input[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                output[i][j] = 0;
            }
        }

        solution();
    }

    private static void solution() {
        for (int i = 0; i < N; i++) {
            List<Integer> list = findConnectedNode(i);
            for (int node : list) {
                output[node][i] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private static List<Integer> findConnectedNode(int i) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> nodeList = new ArrayList<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (int j = 0; j < N; j++) {
                if (input[j][node] == 1 && !nodeList.contains(j)) {
                    queue.offer(j);
                    nodeList.add(j);
                }
            }
        }
        return nodeList;
    }
}
