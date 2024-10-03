import java.util.*;

/*
택시 합승
ans = (무지가 가는 요금 + 어피치가 가는 요금) VS (같이갈 수 있는 곳까지 함께가기 + 거기서 부터 따로가기)

필요 정보 => 각 노드에서 특정 노드로 가는데 드는 최소비용
다익스트라 알고리즘, 플로이드 워셜 알고리즘 사용
n -> 지점 개수
s -> 출발
a -> 목적지 1
b -> 목적지 2
fares -> 노드 간 비용 
*/
class Solution {
    static class Node implements Comparable<Node> {
        int to;
        int w;
        
        public Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
        
        public int compareTo(Node n) {
            return Integer.compare(this.w, n.w);
        }
    }
    static Map<Integer, List<Node>> graph = new HashMap<>();
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] dist = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];
            
            graph.get(from).add(new Node(to, cost));
            graph.get(to).add(new Node(from, cost));
        }
        
        for(int i=1; i<=n; i++) {
             findPath(i, dist[i]);
        }
        
        answer = dist[s][a] + dist[s][b]; 
        for(int midPoint=1; midPoint<=n; midPoint++) {
            answer = Math.min(answer,dist[s][midPoint] + dist[midPoint][a] + dist[midPoint][b]);
        }
        
        return answer;
    }
    
    private void findPath(int start, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(dist, 20000001);
        boolean[] visit = new boolean[dist.length];
        dist[start] = 0;
        
        
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            
            if(visit[cur.to]) continue;
            visit[cur.to] = true;
            
            for(Node adj : graph.get(cur.to)) {
                if(dist[adj.to] > dist[cur.to] + adj.w) {
                    dist[adj.to] = dist[cur.to] + adj.w;
                    pq.add(new Node(adj.to, dist[adj.to]));
                }
            }
            
        }
    }
}