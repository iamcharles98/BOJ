import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
 
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int friends = Integer.parseInt(br.readLine());
            int[] relation = new int[friends + 1];
            String[] point = br.readLine().split(" ");
            for (int i = 1; i <= friends; i++) {
                relation[i] = Integer.parseInt(point[i - 1]);
            }
            sb.append(getNotTeam(relation)).append("\n");
        }
        System.out.print(sb.toString());
    }

    static int getNotTeam(int[] relation) {
        boolean[] visit = new boolean[relation.length];
        boolean[] check = new boolean[relation.length];
        count = 0;
        for (int i = 1; i < relation.length; i++) {
            if (!check[i]) {
                dfs(i, relation, visit, check);
            }
        }

        return relation.length - 1 - count;
    }

    private static void dfs(int i, int[] relation, boolean[] visit, boolean[] check) {

        if (check[i]) {
            return;
        }
        if (visit[i]) {
            check[i] = true;
            count++;
        }
        visit[i] = true;
        dfs(relation[i], relation, visit, check);
        check[i] = true;
        visit[i] = false;
    }

}
