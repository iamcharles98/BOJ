import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int length = citations.length;

        Arrays.sort(citations);

        for (int i = length - 1; 0 <= i; i--){
            if (length - i <= citations[i]) {
                answer = length - i;
            }
        };


        return answer;
    }
}