

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

    static Integer[][] DISTANCE;
    static node TARGET_PLACE;

    static Integer[] dx = {0, 0, -1, 1};
    static Integer[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        MAP = new Integer[N][M];
        DISTANCE = new Integer[N][M];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                MAP[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                DISTANCE[i][j] = Integer.MAX_VALUE;
                // 2 는 목표지점
                if (MAP[i][j] == 2) {
                    TARGET_PLACE = new node(i, j);
                    DISTANCE[i][j] = 0;
                }
                // 0 은 갈 수 없는 땅
                if (MAP[i][j] == 0) {
                    DISTANCE[i][j] = 0;
                }
            }
        }

        findDistance();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(DISTANCE[i][j]!=Integer.MAX_VALUE){
                    sb.append(DISTANCE[i][j]).append(' ');
                } else{
                    sb.append(-1).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private static void findDistance() {
        Queue<node> queue = new LinkedList<>();
        queue.add(TARGET_PLACE);
        while (!queue.isEmpty()) {
            node cur_node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nRow = cur_node.row + dy[i];
                int nCol = cur_node.col + dx[i];
                if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M || MAP[nRow][nCol] == 0) {
                    continue;
                }
                int dist = DISTANCE[cur_node.row][cur_node.col] + 1;
                if (DISTANCE[nRow][nCol] > dist) {
                    DISTANCE[nRow][nCol] = dist;
                    queue.offer(new node(nRow, nCol));
                }
            }
        }
    }

    private static class node {
        int row;
        int col;

        public node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
