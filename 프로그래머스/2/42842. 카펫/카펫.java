import java.util.*;



class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int totalSize = brown + yellow;
        int verticalSize = 3;
       
        while(totalSize / verticalSize >= verticalSize) {
            
            if(totalSize % verticalSize != 0) {
                verticalSize++;
                continue;
            }
            
            if(isBorder(totalSize/verticalSize, verticalSize, brown)) {
                answer[0] = totalSize / verticalSize;
                answer[1] = verticalSize;
                break;
            }
            verticalSize++;
        }
        return answer;
    }
    
    private boolean isBorder(int parallel, int vertical, int brown) {
        return ((parallel * 2) + (vertical * 2) - 4) == brown;
        
    }
}