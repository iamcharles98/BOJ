import java.util.*;
/*
N*M => 최대 1,000,000
공격 갯수 => 250,000
행렬을 직접적으로 업데이트 하면 안됨
skill을 모두 반영한 행렬을 하나 만들고 그것을 딱 반영했을 때, 몇개 살아남았는가 를 판별
스킬을 반영할때도 O(N^2)가 걸리면 안됨

1, 1 => 3,3 까지 2를 회복

2 2 2    (r1,r2)2 0 0 -2 (r1,c2+1)
2 2 2    0 0 0 0
2 2 2    0 0 0 0
         (c1+1, r2)-2     2 (c1+1,c2+1)
         
         
         2차원에서도 =>(a,b) => (c,d) 까지 공격한다 가정하면 양 끝점만 변경해주면 됨
         
         마지막에 1,1 부터 n,n 까지 누적합을 구해주면 총 공격 및 회복 결과가 나옴
         
*/
class Solution {
    public int solution(int[][] board, int[][] skills) {
        int answer = 0;
        int[][] score = new int[board.length+1][board[0].length+1];
        
        for(int [] skill : skills) {
            int type = skill[0];
            int r1 = skill[1];
            int r2 = skill[2];
            int c1 = skill[3];
            int c2 = skill[4];
            int degree = skill[5];
            
            degree = (type == 1) ? degree*(-1) : degree;
            
            score[r1][r2] += degree;
            score[r1][c2+1] += degree*(-1);
            score[c1+1][r2] += degree*(-1);
            score[c1+1][c2+1] += degree;
        }
        
        for(int i=1; i< score.length; i++) {
            score[0][i] += score[0][i-1];
            score[i][0] += score[i-1][0];
        }
        
        for(int i=1; i< score.length-1; i++) {
            for(int j=1; j<score[i].length-1; j++) {
                score[i][j] += score[i-1][j] + score[i][j-1] - score[i-1][j-1];
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] + score[i][j] > 0) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}