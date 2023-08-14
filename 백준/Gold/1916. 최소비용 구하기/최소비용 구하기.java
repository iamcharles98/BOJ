

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int startNode;
    static int endNode;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        /*
        그래프 비용 입력받기
         */
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int cost = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(start).add(new Node(end, cost));
        }

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        startNode = Integer.parseInt(stringTokenizer.nextToken());
        endNode = Integer.parseInt(stringTokenizer.nextToken());

        System.out.print(dijkstra(graph));

    }

    private static int dijkstra(List<List<Node>> graph) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight;
            }
        });
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startNode] = 0;
        Set<Integer> visit = new HashSet<>();
        queue.add(new Node(startNode, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (visit.contains(curNode.vertex)) {
                continue;
            }
            visit.add(curNode.vertex);
            for (Node adjacentNode : graph.get(curNode.vertex)) {
                if (dist[adjacentNode.vertex] > dist[curNode.vertex] + adjacentNode.weight) {
                    dist[adjacentNode.vertex] = dist[curNode.vertex] + adjacentNode.weight;
                    queue.add(new Node(adjacentNode.vertex, dist[adjacentNode.vertex]));
                }
            }
        }
        return dist[endNode];

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
