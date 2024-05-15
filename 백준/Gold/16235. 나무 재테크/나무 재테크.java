import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K;
    static int[][] food;
    static int[][] S2D2;
    static List<Tree> treeList = new ArrayList<>();
    static Deque<Integer> deadTree = new LinkedList<>();

    static class Tree {
        int x, y;
        int age;
        boolean isDead;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
            isDead = false;
        }

        public void dead() {
            this.isDead = true;
        }
    }


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        food = new int[N + 1][N + 1];
        S2D2 = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                food[i][j] = 5;
                S2D2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            treeList.add(new Tree(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < K; i++) {
            doSpring();
            doSummmer();
            doAutumn();
            doWinter();
        }

        System.out.println(treeList.size());

    }


    private static void doSpring() {
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);
            if (food[tree.x][tree.y] < tree.age) {
                deadTree.add(i);
                continue;
            }
            food[tree.x][tree.y] -= tree.age;
            tree.age += 1;
        }
    }

    private static void doSummmer() {
        while (!deadTree.isEmpty()) {
            Tree tree = treeList.get(deadTree.pollLast());
            food[tree.x][tree.y] += tree.age / 2;
            tree.dead();
        }
    }

    private static void doAutumn() {
        List<Tree> newTreeList = new ArrayList<>();
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);
            if (tree.isDead) {
                continue;
            }

            if (tree.age % 5 == 0) {
                for (int row = -1; row <= 1; row++) {
                    for (int col = -1; col <= 1; col++) {
                        if (row == 0 && col == 0) {
                            continue;
                        }
                        int nx = tree.x + row;
                        int ny = tree.y + col;
                        if (nx < 1 || ny < 1 || nx > N || ny > N) {
                            continue;
                        }
                        newTreeList.add(new Tree(nx, ny, 1));
                    }
                }
            }
        }

        for (Tree tree : treeList) {
            if (!tree.isDead) {
                newTreeList.add(tree);
            }
        }
        treeList = newTreeList;
    }

    private static void doWinter() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                food[i][j] += S2D2[i][j];
            }
        }
    }
}
