

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int start;
    static int end;
    static final int INF = 100000000;
    static List<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int e = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(s).add(new Node(e, w));
        }
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        start = Integer.parseInt(stringTokenizer.nextToken());
        end = Integer.parseInt(stringTokenizer.nextToken());

        dijkstra(start, end);

    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        Set<Integer> visit = new HashSet<>();
        int[] path = new int[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (visit.contains(curNode.vertex)) {
                continue;
            }
            visit.add(curNode.vertex);
            for (Node adjacentNode : graph.get(curNode.vertex)) {
                if (!visit.contains(adjacentNode.vertex) && dist[adjacentNode.vertex] > dist[curNode.vertex] + adjacentNode.weight) {
                    dist[adjacentNode.vertex] = dist[curNode.vertex] + adjacentNode.weight;
                    queue.add(new Node(adjacentNode.vertex, dist[adjacentNode.vertex]));
                    path[adjacentNode.vertex] = curNode.vertex;
                }
            }
        }
        System.out.println(dist[end]);
        List<Integer> ans = new ArrayList<>();
        int parent = end;

        while (parent!=start) {
            ans.add(parent);
            parent = path[parent];
        }
        ans.add(start);
        System.out.println(ans.size());
        Collections.reverse(ans);
        for(int i=0;i<ans.size();i++) {
            System.out.print(ans.get(i) + " ");
        }
    }

    private static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}
