

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Integer N;
    static Integer M;
    static Integer[][] MAP;
    static Integer[] moveX = {0, 0, -1, 1};
    static Integer[] moveY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        MAP = new Integer[N][M];
        String inputString;
        for (int i = 0; i < N; i++) {
            inputString = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Character.getNumericValue(inputString.charAt(j));
            }
        }

        solution(new Node(0, 0, 1));

    }

    private static void solution(Node node) {
        Integer[][] count = new Integer[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();


            for (int i = 0; i < 4; i++) {
                int newRow = curNode.row + moveX[i];
                int newCol = curNode.col + moveY[i];
                int newCount = curNode.count + 1;
                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M || MAP[newRow][newCol] == 0) {
                    continue;
                }
                if (count[newRow][newCol] > newCount) {
                    count[newRow][newCol] = newCount;
                    queue.add(new Node(newRow, newCol, newCount));
                }
            }
        }
        System.out.println(count[N - 1][M - 1]);
    }

    static class Node {
        int row;
        int col;

        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
