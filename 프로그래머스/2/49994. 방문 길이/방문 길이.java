import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        
        int answer = 0;
        int[] curPos = new int[] {5,5};
        boolean [][][] visit = new boolean[4][11][11];
        
        for(char command : dirs.toCharArray()) {
            
            switch(command) {
                
                case 'U' :
                    if(curPos[1] < 10) {
                        if(!visit[0][curPos[0]][curPos[1]+1] && !visit[1][curPos[0]][curPos[1]]) {
                            answer ++;
                            visit[0][curPos[0]][curPos[1]+1]=true;
                            visit[1][curPos[0]][curPos[1]]=true;
                        }
                        curPos[1] = curPos[1]+1;
                    }
                    break;
                case 'D' : 
                    if(curPos[1] > 0) {
                        if(!visit[1][curPos[0]][curPos[1]-1] && !visit[0][curPos[0]][curPos[1]]) {
                            answer ++;
                            visit[1][curPos[0]][curPos[1]-1]=true;     
                            visit[0][curPos[0]][curPos[1]]=true;
                        }
                        curPos[1] = curPos[1]-1;
                    }
                    break;
                case 'R' : 
                    if(curPos[0] < 10) {
                        if(!visit[2][curPos[0]+1][curPos[1]] && !visit[3][curPos[0]][curPos[1]]) {
                            answer ++;
                            visit[2][curPos[0]+1][curPos[1]] = true;
                            visit[3][curPos[0]][curPos[1]] = true;
                        }
                        curPos[0] = curPos[0]+1;
                    }
                    break;
                case 'L' : 
                    if(curPos[0] > 0) {
                        if(!visit[3][curPos[0]-1][curPos[1]] && !visit[2][curPos[0]][curPos[1]]) {
                            answer ++;
                            visit[3][curPos[0]-1][curPos[1]]=true;
                            visit[2][curPos[0]][curPos[1]] = true;
                        }
                        curPos[0] = curPos[0]-1;
                    }
                    break;      
            }
        }
        
        
        return answer;
    }
}