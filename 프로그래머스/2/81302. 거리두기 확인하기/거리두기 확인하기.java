import java.util.*;
import java.lang.*;
class Solution {
    static class Player {
        int x;
        int y;
        public Player (int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public int between(Player p) {
            return Math.abs(x - p.x) + Math.abs(y - p.y);
        }
    }
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int idx = 0;
        for(String [] place : places) {
            if(followRule(place)) {
                answer[idx] = 1;
            }
            idx ++;
        }
        
        return answer;
    }
    
    private boolean followRule(String [] place) {
        List<Player> players = findPlayer(place);
        
        for(int idx = 0; idx<players.size(); idx++) {
            Player p = players.get(idx);
            for(int next=idx+1; next<players.size(); next++) {
                Player np = players.get(next);
                if(p.between(np) <= 2 && !hasPartition(p, np, place)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean hasPartition(Player p1, Player p2, String [] place) {
        if(p1.between(p2) == 1) {
            return false;
        }
        if(p1.x == p2.x) {
            int minY = Math.min(p1.y, p2.y);
            if(place[minY+1].charAt(p1.x) == 'X') {
                return true;
            }
            return false;
        }
        if(p1.y == p2.y) {
            int minX = Math.min(p1.x, p2.x);
            if(place[p1.y].charAt(minX+1) == 'X') {
                return true;
            }
            return false;
        }
        
        if(p1.x < p2.x) {
            if(place[p1.y].charAt(p1.x+1) == 'X' && place[p2.y].charAt(p2.x-1) == 'X') {
                return true;
            }
            return false;
        }
        else{
            if(place[p2.y].charAt(p2.x+1) == 'X' && place[p1.y].charAt(p1.x-1) == 'X') {
                return true;
            }
            return false;
        }
        
    }
    
    private List<Player> findPlayer(String [] place) {
        List<Player> players = new ArrayList<>();
        for(int i=0; i<place.length; i++) {
            String row = place[i];
            for(int j=0; j<row.length(); j++) {
                if(row.charAt(j) == 'P') {
                    players.add(new Player(j,i));
                }
            }
        }
        return players;
    }
    

}