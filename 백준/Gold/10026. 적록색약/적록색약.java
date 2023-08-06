

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static Integer N;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static Character[][] GRID;

    static Character[][] DEFICIENT_GRID;
    static boolean[][] visit;

    static List<Character> DEFICIENT_COLOR = List.of('R', 'G');

    static Integer cnt = 0;
    static Integer Dcnt = 0;

    static Integer[] dx = {1, -1, 0, 0};
    static Integer[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        GRID = new Character[N][N];
        DEFICIENT_GRID = new Character[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                Character character = input.charAt(j);
                GRID[i][j] = character;
                if (DEFICIENT_COLOR.contains(character)) {
                    DEFICIENT_GRID[i][j] = 'D';
                    continue;
                }
                DEFICIENT_GRID[i][j] = character;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (GRID[i][j] != 'V') {
                    dfs(i, j, GRID);
                    cnt++;
                }
                if (DEFICIENT_GRID[i][j] != 'V') {
                    dfs(i, j, DEFICIENT_GRID);
                    Dcnt++;
                }
            }
        }

        System.out.println(cnt + " " + Dcnt);


    }

    private static void dfs(int i, int j, Character[][] map) {

        Character color = map[i][j];
        map[i][j] = 'V';

        for (int num = 0; num < 4; num++) {
            int ny = i + dy[num];
            int nx = j + dx[num];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 'V') {
                continue;
            }
            if (map[ny][nx] == color) {
                dfs(ny, nx, map);
            }
        }
    }


}
