import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] parent;

    static class Road implements Comparable<Road> {
        int from;
        int to;
        int cost;

        public Road(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return this.cost - o.cost;
        }

        @Override
        public String toString() {
            return "Road{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        PriorityQueue<Road> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            pq.add(new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        int minCost = 0;
        int edgeCount = 0;
        while (edgeCount < N - 2) {

            Road road = pq.poll();

            int parentFrom = find(road.from);
            int parentTo = find(road.to);

            if (parentFrom != parentTo) {
                union(parentFrom, parentTo);
                edgeCount++;
                minCost += road.cost;
            }
        }
        System.out.println(minCost);
    }

    private static void union(int from, int to) {
        if (from < to) {
            parent[to] = from;
            return;
        }
        parent[from] = to;
    }

    private static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}
