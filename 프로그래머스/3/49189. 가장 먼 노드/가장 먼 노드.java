import java.util.*;

/*
일단 그래프를 어레이리스트 자료구조로 표현
1번 부터 BFS로 그래프 순회
레벨 별 방문 노드 추가
*/
class Solution {
    public int solution(int n, int[][] edges) {
        int answer = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1; i<=n; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for(int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int[] visit = new int[n+1];
        int level = 0;
        Arrays.fill(visit, -1);
        queue.add(1);
        visit[1] = 0;
        while(!queue.isEmpty()) {
            level ++;
            int curSize = queue.size();
            for(int i= curSize; i>0; i--) {
            int cur = queue.poll();
            
            for(int node : graph.get(cur)) {
                if(visit[node] == -1) {
                    visit[node] = level;
                    queue.add(node);
                }
            }
        }
    }
        for(int lev : visit) {
            if(lev == level-1) {
                answer++;
            }
        } 
        return answer;
    }
}