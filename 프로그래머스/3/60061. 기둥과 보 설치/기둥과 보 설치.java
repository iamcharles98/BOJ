import java.util.*;

class Solution {
    static int [][][] map;
    static final int KIDOONG = 0;
    static final int BO = 1;
    static int size;
    
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        size = n;
        map = new int[2][n+1][n+1];
        int buildingNum = 0;
        for(int [] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int option = build[3];
            
            if(option == 1) {
                if(install(x,y,a)) {
                    map[a][y][x] = 1;
                    buildingNum++;
                };
            }
            else {
                if(delete(x,y,a)) {
                    buildingNum--;
                }
            }
        }
        answer= new int[buildingNum][3];
        int idx = 0; 
        for(int x=0; x<n+1;x++) {
            for(int y=0; y<n+1;y++) {
                for(int type = 0; type<2; type++){
                    if(map[type][y][x] == 1) {
                        answer[idx][0] = x;
                        answer[idx][1] = y;
                        answer[idx][2] = type;
                        idx++;
                    }
                }
            }
        }
        
        return answer;
    }
    
    private boolean install(int x, int y, int type) {
        if(type == KIDOONG) {
            if(y==0) {return true;}
            if(y-1 >= 0 && map[KIDOONG][y-1][x] == 1) {return true;}
            if(x+1 <= size && map[BO][y][x] == 1) {return true;}
            if(x-1 >= 0 && map[BO][y][x-1] == 1) {return true;}
        }else {
            if(y-1>=0 && (map[KIDOONG][y-1][x] == 1 || map[KIDOONG][y-1][x+1] == 1) ) {return true;}
            if(x-1 >= 0 && x+2 <= size && map[BO][y][x-1] == 1 && map[BO][y][x+1] == 1) {return true;}
        }
        return false;
    }
    
    private boolean delete(int x, int y, int type) {
        map[type][y][x] = 0;
        boolean canDelete = true;
        if(type == KIDOONG) {
            if(y+2 <= size && map[KIDOONG][y+1][x] == 1 && !install(x, y+1,type)) { canDelete = false;}
            if(x+1 <= size && map[BO][y+1][x] == 1 && !install(x,y+1,BO)) {canDelete = false;}
            if(x-1 >= 0 && map[BO][y+1][x-1] == 1 && !install(x-1,y+1,BO)) {canDelete = false;}
        }
        else {
            if(x+2 <= size && map[BO][y][x+1] == 1 && !install(x+1,y,BO)) {canDelete = false;}
            if(x-1 >= 0 && map[BO][y][x-1] == 1 && !install(x-1,y,BO)) {canDelete = false;}
            if(y+1 <= size && map[KIDOONG][y][x]==1 && !install(x,y,KIDOONG)) {canDelete = false;}
            if(y+1 <= size && map[KIDOONG][y][x+1] == 1 && !install(x+1,y,KIDOONG)){canDelete = false;}
        }
        if(canDelete == false) {
            map[type][y][x] = 1;
        }
        return canDelete;
    }
}