

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Map<Integer, List<Edge>> graph = new HashMap<>();
    static int N;
    static boolean[] visit;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static class Edge {
        int v1;
        int w;

        public Edge(int v1, int w) {
            this.v1 = v1;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 1; j <= N; j++) {
                int w = Integer.parseInt(stringTokenizer.nextToken());
                if (i != j) {
                    graph.get(i).add(new Edge(j, w));
                }
            }
        }
        prim();

    }

    private static void prim() {
        long min = 0;
        Queue<Edge> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        queue.add(new Edge(1, 0));
        while (!queue.isEmpty()) {
            Edge cur = queue.poll();
            if (!visit[cur.v1]) {
                visit[cur.v1] = true;
                min += (long)cur.w;
                for (Edge e : graph.get(cur.v1)) {
                    if (!visit[e.v1]) {
                        queue.add(e);
                    }
                }
            }
        }
        System.out.println(min);
    }
}
