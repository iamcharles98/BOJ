import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, K, X;
    static int MAX = 1_000_001;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph.get(from).add(to);
        }
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);
        dist[X] = 0;

        findPath(X, graph, dist);
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (dist[i] == K) {
                sb.append(i).append("\n");
            }
        }
        String ans = sb.toString();
        if (ans.equals("")) {
            System.out.print(-1);
        } else {
            System.out.print(ans);
        }

    }

    private static void findPath(int x, Map<Integer, List<Integer>> graph, int[] dist) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(x);


        while (!pq.isEmpty()) {
            int cur = pq.poll();

            for (int adj : graph.get(cur)) {
                if (dist[adj] > dist[cur] + 1) {
                    dist[adj] = dist[cur] + 1;
                    pq.add(adj);
                }
            }
        }
    }


}
