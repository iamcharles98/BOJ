import java.util.*;
class Solution {
    /*
    n개의 노드
    0 부터 n-1 개
    0 에서 n-1까지 갈 수 있는 모든 경로를 반환, 순서 X

    graph -> 인덱스 i 에서 방문할 수 있는 노드들을 담고있다.

    DFS
    [[1,2],[3],[3],[]]

    1,2 스택에 추가
    2 방문
    3 방문 0 -> 2 -> 3 (경로 발견)
    1 방문
    3 방문 0 -> 1 -> 3 (경로 발견)

    0 번 노드에 연결되어 있는 
    */
    static List<List<Integer>> answer ;
    static int N;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        N = graph.length-1;
        answer = new ArrayList<>();
        List<Integer> list = new ArrayList();
        DFS(list, 0, graph);


        return answer;
        
    }

    static private void DFS(List<Integer> list, int curNode, int[][] graph) {
        List<Integer> curList= new ArrayList<>(list);
        curList.add(curNode);
        //마지막 노드에 도달했으면 정답추가 //
        if(curNode == N ) {
            answer.add(curList);
            return;
        }
        /*
        이 부분을 굳이 스택에 옮겨 담아서 실행할 필요가 없을 것 같다 
        Stack<Integer> stack = new Stack<>();
        for(int i : graph[curNode]) {
            stack.add(i);
        }
        */
        for(int i : graph[curNode]) {
            DFS(curList, i, graph);
        }
        return;
    }
}