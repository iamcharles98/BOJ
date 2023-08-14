
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int E;
    static int startNode = 1;
    static int endNode;
    static int visitNode1;
    static int visitNode2;
    static List<ArrayList<Node>> graph;
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        E = Integer.parseInt(stringTokenizer.nextToken());
        endNode = N;
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int from = Integer.parseInt(stringTokenizer.nextToken());
            int to = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(from).add(new Node(to, w));
            graph.get(to).add(new Node(from, w));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        visitNode1 = Integer.parseInt(stringTokenizer.nextToken());
        visitNode2 = Integer.parseInt(stringTokenizer.nextToken());


        int dist1 = dijkstra(startNode, visitNode1);
        int dist2 = dijkstra(visitNode1, visitNode2);
        int dist3 = dijkstra(visitNode2, endNode);
        int res1 = dist1 + dist2 + dist3;

        int dist4 = dijkstra(startNode, visitNode2);
        int dist5 = dijkstra(visitNode2, visitNode1);
        int dist6 = dijkstra(visitNode1, endNode);
        int res2 = dist4 + dist5 + dist6;

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(ans);
    }

    private static int dijkstra(int startNode, int targetNode) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[startNode] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        Set<Integer> visit = new HashSet<>();
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (visit.contains(curNode)) {
                continue;
            }
            visit.add(curNode.vertex);

            for (Node adjacentNode : graph.get(curNode.vertex)) {
                if (!visit.contains(adjacentNode.vertex) && dist[adjacentNode.vertex] > dist[curNode.vertex] + adjacentNode.weight) {
                    dist[adjacentNode.vertex] = dist[curNode.vertex] + adjacentNode.weight;
                    queue.add(new Node(adjacentNode.vertex, dist[adjacentNode.vertex]));
                }
            }
        }
        return dist[targetNode];
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
