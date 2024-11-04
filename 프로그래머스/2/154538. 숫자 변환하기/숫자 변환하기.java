import java.util.*;

class Solution {
    /*
    최소연산
    dp가 가능할 것 같은데
    1부터 1,000,000 까지 각 숫자를 최소연산으로 도달하도록!?
    */
    
    static int [] board;
    static class Node implements Comparable<Node> {
        int num;
        int opCount;
        
        public Node(int n, int op) {
            this.num = n;
            this.opCount = op;
        }
        
        public int compareTo(Node n) {
            return Integer.compare(this.opCount, n.opCount);
        }
    }
    
    public int solution(int x, int y, int n) {
        board = new int[y+1];
        Arrays.fill(board, -1);
        
        PriorityQueue<Node> qu = new PriorityQueue<>();
        qu.add(new Node(x,0));
        
        
        while(!qu.isEmpty()) {
            Node cur = qu.poll();
            
            if(cur.num >= board.length) {
                continue;
            }
            
            if(board[cur.num] != -1 && board[cur.num] <= cur.opCount) {
                continue;
            }
            
            board[cur.num] = cur.opCount;
            
            qu.add(new Node(cur.num*3, cur.opCount+1));
            qu.add(new Node(cur.num*2, cur.opCount+1));
            qu.add(new Node(cur.num+n, cur.opCount+1));
        }
        
        
        return board[y];
    }

}