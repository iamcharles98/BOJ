import java.util.*;

class Solution {
    /*
    우선 집이 위치한 곳의 세로행과 가로열은 물웅덩이가 존재하지 않는다면 1가지 방법밖에 존재하지 않는다.
    
    위에 언급된 위치를 제외한 모든 칸은 물웅덩이가 아니라면, 해당 칸에 도달하는 경우의 수는 위쪽칸에 도달하는 방법 + 해당 칸 왼쪽칸에 도달하는 방법이다.
    
    
    */
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int [][] path = new int[n+1][m+1];
        
        path[1][1] = 1;
        
        for (int i = 0; i < puddles.length; i++){
            path[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        for(int row = 1; row<=n; row++) {
            for(int col=1; col<=m; col++) {
                if(path[row][col]==0){
                    path[row][col] = Math.max(path[row-1][col],0) + Math.max(path[row][col-1], 0);
                    path[row][col] %= 1000000007;
                }
            }
        }
        
        return path[n][m];
    }
  
}