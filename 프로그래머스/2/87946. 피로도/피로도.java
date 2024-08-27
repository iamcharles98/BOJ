import java.util.*;

/*
최소 필요 피로도, 소모 피로도
최소 => 80, 소모 피로도 -> 20
현재 피로도 80이상 , 던전 탐험 후 피로도 20 소모

최대한 많은 모험하는 방법
던전의 갯수 -> 최대 8개
가능한 조합 수 -> 8! 약 4만
*/

class Solution {
    
    static List<int[]> permutations = new ArrayList<>();
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        int dungeonLength = dungeons.length;
        permutation(new int[dungeonLength], new boolean[dungeonLength], 0, dungeonLength);
        
        for(int[] way : permutations) {
            int cnt = tourDungeon(way, dungeons, k);
            if(cnt > answer) {
                answer = cnt;
            }
        }
            
        return answer;
    }
    
    private int tourDungeon(int [] way, int[][] info, int k) {
        int cnt = 0;
        for(int dungeonNum : way) {
            int atLeast = info[dungeonNum][0];
            if(k<atLeast) {
                break;
            }
            k-= info[dungeonNum][1];
            cnt++;
        }
        return cnt;
    }
   
    private void permutation(int [] arr, boolean[] visit, int depth, int r) {
        if(depth == r) {
            permutations.add(Arrays.copyOf(arr, arr.length));
            return;
        }
        
        for(int i=0; i<r; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                permutation(arr, visit, depth+1, r);
                visit[i] = false;
            }
        }
    }
}