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
    static final int TEAM = 1;
    static final int NOT_TEAM = 2;

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
        int[] board = new int[relation.length];

        for (int i = 1; i < relation.length; i++) {
            if (board[i] == 0) {
                dfs(i, new HashSet<>(), relation, board);
            }
        }

        return relation.length - 1 - board[0];
    }

    private static void dfs(int i, Set<Integer> visit, int[] relation, int[] board) {
        if(board[i] != 0) {
            return;
        }
        if (!visit.add(i)) {
            board[i] = TEAM;
            board[0]++;
        }

        dfs(relation[i], visit, relation, board);
        board[i] = NOT_TEAM;
        
    }

}
