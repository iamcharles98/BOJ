

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visit;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        visit = new boolean[N+1];
        parent = new int[N+1];
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < N+1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }


        dfs(tree, 1);

        for(int i=2;i<=N;i++) {
            System.out.print(parent[i] + " ");
        }

    }

    private static void dfs(ArrayList<ArrayList<Integer>> tree, int i) {
        visit[i] = true;
        for(Integer node : tree.get(i)) {
            if(!visit[node]){
                parent[node] = i;
                dfs(tree,node);
            }
        }
    }

}
