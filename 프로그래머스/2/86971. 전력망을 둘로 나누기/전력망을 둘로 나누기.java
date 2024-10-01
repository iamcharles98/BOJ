import java.util.*;

class Solution {
    static Map<Integer, List<Integer>> tree = new HashMap<>();
    
    public int solution(int n, int[][] wires) {
        
        for(int i=1; i<=n; i++) {
            tree.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<wires.length; i++) {
            tree.get(wires[i][0]).add(wires[i][1]);
            tree.get(wires[i][1]).add(wires[i][0]);
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int key : tree.keySet()) {
            for(int node : tree.get(key)) {
                
                int subSize = Math.abs(n-2*findSizeOfSubTree(node, key));
                if(min>subSize) {
                    min = subSize;
                }
            }
        }
        
        
        return min;
    }
    
    private int findSizeOfSubTree(int node, int from) {
        
        Set<Integer> visit = new HashSet<>();
        visit.add(from);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        int size = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            visit.add(cur);
            
            for(int child : tree.get(cur)) {
                if(!visit.contains(child)) {
                    queue.add(child);
                    size++;
                }
            }
        }
        return size;
    }
}