

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Integer M;
    static Integer N;
    static Integer H;

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static Integer[][][] BOX;

    static Queue<Node> queue = new LinkedList<>();
    static Integer DAY = 0;
    static Integer UNDONE_TOMATO_NUM = 0;

    static Integer[] move_x = {1, -1, 0, 0, 0, 0};
    static Integer[] move_y = {0, 0, 1, -1, 0, 0};
    static Integer[] move_z = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        M = Integer.parseInt(stringTokenizer.nextToken());
        N = Integer.parseInt(stringTokenizer.nextToken());
        H = Integer.parseInt(stringTokenizer.nextToken());
        BOX = new Integer[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int k = 0; k < M; k++) {
                    BOX[i][j][k] = Integer.parseInt(stringTokenizer.nextToken());
                    if (BOX[i][j][k] == 1) {
                        queue.add(new Node(i, j, k));
                    }
                    if (BOX[i][j][k] == 0) {
                        UNDONE_TOMATO_NUM++;
                    }
                }
            }
        }

        solution();


    }

    private static void solution() {
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }
        if (UNDONE_TOMATO_NUM == 0) {
            System.out.println(0);
            return;
        }

        while (!queue.isEmpty()) {
            Queue<Node> nextQueue = new LinkedList<>(queue);
            queue.clear();
            while (!nextQueue.isEmpty()) {
                Node tomato = nextQueue.poll();
                for (int i = 0; i < 6; i++) {
                    int new_H = tomato.h + move_z[i];
                    int new_N = tomato.n + move_y[i];
                    int new_M = tomato.m + move_x[i];
                    if (new_H < 0 || new_H >= H || new_N < 0 || new_N >= N || new_M < 0 || new_M >= M || BOX[new_H][new_N][new_M] != 0) {
                        continue;
                    }
                    if (BOX[new_H][new_N][new_M] == 0) {
                        BOX[new_H][new_N][new_M] = 1;
                        UNDONE_TOMATO_NUM--;
                        queue.add(new Node(new_H, new_N, new_M));
                    }
                }
            }
            DAY++;

        }

        if (UNDONE_TOMATO_NUM != 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(DAY - 1);
        return;
    }

    private static class Node {
        Integer h;
        Integer n;
        Integer m;

        public Node(Integer h, Integer n, Integer m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}
