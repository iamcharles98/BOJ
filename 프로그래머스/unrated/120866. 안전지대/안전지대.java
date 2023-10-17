class Solution {
    static int [] dx = {0,0,-1,1,-1,1,-1,1};
    static int [] dy = {1,-1,0,0,1,1,-1,-1};
    public int solution(int[][] board) {
        int answer = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0;j<board[i].length; j++) {
                if(board[i][j] == 1) {
                    for(int k=0; k< 8 ;k++) {
                        int x = dy[k] + i;
                        int y = dx[k] + j;
                        if(x < 0 || y<0 || x>=board.length || y >= board[i].length) {
                            continue;
                        }
                        if(board[x][y] == 1) {
                            continue;
                        }
                        board[x][y] = 3;
                    }
                }
            }
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0;j<board[i].length; j++) {
                if(board[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}