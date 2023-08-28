import java.util.*;

class Solution {
    /*
    1 - n 까지의 노드로 구성된 무방향 스타 그래프
    스타그래프 -> 중심에 노드 한개 + 다른노드와 모두 연결
    엣지가 주어지면 해당 그래픵 중심 노드를 반환하시오

    노드 해쉬테이블로 구성해서 순회하면서 다른 모든 노드 포함한 노드 반환

    //특정 한 노드가 계속 등장해야 하니까 두 엣지만 비교해서 정답 도출도 가능하다 !
    */
    public int findCenter(int[][] edges) {
        int answer = 0;

        int [] edge1 = edges[0];
        int [] edge2 = edges[1];

        
            for(int j=0; j<2; j++) {
                if(edge1[0] == edge2[j]) {
                    answer = edge1[0];
                    break;
                }
            }
            if(answer==0) {
                answer = edge1[1];
            }
            return answer;
        }
        /*Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<edges.length;i++) {
            int [] edge = edges[i];
            int node1 = edge[0];
            int node2 = edge[1];

            if(!map.containsKey(node1)) {
                map.put(node1,new ArrayList<>());
            }
            if(!map.containsKey(node2)) {
                map.put(node2,new ArrayList<>());
            }
            map.get(node1).add(node2);
            map.get(node2).add(node1);
        }

        int nodeNum = map.keySet().size();
        for(int key : map.keySet()) {
            if(map.get(key).size() == nodeNum-1) {
                answer = key;
                break;
            }
        }*/
        
    }
