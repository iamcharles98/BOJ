

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static Integer N;
    static Integer M;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static Integer[] MAP = new Integer[101];
    static Integer[] visit = new Integer[101];


    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i <= 100; i++) {
            MAP[i] = 0;
            visit[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            MAP[Integer.parseInt(stringTokenizer.nextToken())] = Integer.parseInt(stringTokenizer.nextToken());
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            MAP[Integer.parseInt(stringTokenizer.nextToken())] = Integer.parseInt(stringTokenizer.nextToken());
        }


        dfs(1, 0);

        System.out.println(visit[100]);

    }

    private static void dfs(int cur_pos, int cnt) {
        if (cur_pos > 100) {
            return;
        }

        if (visit[cur_pos] <= cnt) {
            return;
        }

        if (MAP[cur_pos] == 0 && cnt < visit[cur_pos]) {
            for (int i = 1; i <= 6; i++) {
                visit[cur_pos] = cnt;
                dfs(roll(cur_pos, i), cnt + 1);
            }
            return;
        }

        dfs(MAP[cur_pos], cnt);


    }

    private static Integer roll(int cur_pos, int dice) {
        return cur_pos + dice;
    }
}
