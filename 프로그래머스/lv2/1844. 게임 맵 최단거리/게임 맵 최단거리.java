import java.util.*;
class Solution {
    /*
    두 팀이서 게임 진행
    상대 팀 진영에 최대한 빨리 도착
    나 (1,1)에 위치 / 상대 (5,5)에 위치
    동서남북 한 칸씩 이동 (검은부분 이동 불가)
    최소로 이동해서 상대 칸에 도착하는데 이동 칸 수를 return
    이동 불가능 하면 -1
    
    N * M 크기 맵 (1<= N, M <= 100)
    0은 벽이 있는 자리, 1은 이동 가능
    BFS로 이동 -> 이동칸에 지나온 칸수 기록하여 (적혀있는 수보다 큰수로 이동시 이동 X)
    
    BFS -> 효율성 테스트 실패 -> 모든 가능한 경로를 다 보아서 ?
    DFS -> 
    */
    static int[][] visit;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static int N, M;
    static int min = 100001;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visit = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                visit[i][j] = 100001;
            }
        }
        return BFS(new Node(0,0,0),maps);
        /*int answer = (visit[N-1][M-1] == -1 ) ? -1 : visit[N-1][M-1]+1;
        */
        /*DFS(0,0,0,maps);
        return (min==100001) ? -1 : min+1;
        */
    }
    
    /*public static void DFS(int row,int col, int depth,int [][] map) {
        visit[row][col] = depth;
        if(row == N-1 && col == M-1) {
            min = Math.min(min,depth);
            return;
        }
        
        for(int i=0 ; i<4; i++) {
            int nRow = row + dy[i];
            int nCol = col + dx[i];
            int cnt = depth+1;
            if(nRow < 0 || nRow >= N || nCol < 0 || nCol >= M|| map[nRow][nCol]==0) {
                continue;
            }
            if(visit[nRow][nCol] > cnt) {
                DFS(nRow,nCol,depth+1,map);
            }
        }
        
    }*/
    public static int BFS(Node node, int[][] map) {
        int min = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            
            if(cur.row==N-1 && cur.col == M-1) {
                min = cur.cnt+1;
                break;
            }
            for(int i=0;i<4;i++) {
                int nRow = cur.row + dy[i];
                int nCol = cur.col + dx[i];
                int nCnt = cur.cnt+1;
                if(nRow<0 || nRow >=N || nCol <0 || nCol >=M || map[nRow][nCol]==0 || visit[nRow][nCol] <= nCnt) {
                    continue;
                }
                visit[nRow][nCol] = nCnt;
                queue.add(new Node(nRow,nCol,nCnt));
            }
        }
        return min;
    }
    
    private static class Node {
        int row;
        int col;
        int cnt;
        public Node (int row, int col, int cnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
        }
    }
}