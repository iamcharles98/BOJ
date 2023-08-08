

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Integer max = Integer.MIN_VALUE;
    static Integer[] dx = {-1, 1, 0, 0};
    static Integer[] dy = {0, 0, -1, 1};

    static int[][] map;
    static boolean[][] visit;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                Node node = new Node(x, y, map[y][x]);
                visit[y][x] = true;
                dfs(node, 1);
                visit[y][x] = false;
            }
        }
        System.out.println(max);


    }

    private static void dfs(Node node, int count) {
        if (count == 4) {
            if (node.sum > max) {
                max = node.sum;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = node.x + dx[i];
            int ny = node.y + dy[i];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N || visit[ny][nx]) {
                continue;
            }
            if (count == 2) {
                visit[ny][nx] = true;
                dfs(new Node(node.x, node.y, node.sum + map[ny][nx]), (count + 1));
                visit[ny][nx] = false;
            }
            visit[ny][nx] = true;
            dfs(new Node(nx, ny, node.sum + map[ny][nx]), (count + 1));
            visit[ny][nx] = false;
        }
    }

    private static class Node {
        int x;
        int y;
        int sum;

        public Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }


}
