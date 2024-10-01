import java.util.*;

class Solution {
    static class PlayInfo implements Comparable<PlayInfo> {
        int number;
        int play;
        
        public PlayInfo(int num, int play) {
            this.number = num;
            this.play = play;
        }
        
        public int compareTo(PlayInfo p) {
            if(this.play == p.play) {
                return this.number - p.number;
            }
            return p.play - this.play;
        }
    }
    
    
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> score = new HashMap<>();
        Map<String, PriorityQueue<PlayInfo>> songs = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            String genre = genres[i];
            score.put(genre, score.getOrDefault(genre,0)+plays[i]);
            
            if(!songs.containsKey(genre)) {
                songs.put(genre, new PriorityQueue<>());
            }
            songs.get(genre).add(new PlayInfo(i, plays[i]));
        }
        
        List<String> key = new ArrayList<>(score.keySet());
        
        key.sort(new Comparator<String>() {
            
            public int compare(String s1, String s2) {
                return score.get(s2) - score.get(s1);
            }
        });
        
        for(String g : key) {
            int cnt = 0;
            while(!songs.get(g).isEmpty() && cnt<2) {
                answer.add(songs.get(g).poll().number);
                cnt++;
            }
        }
        return answer;
    }
}