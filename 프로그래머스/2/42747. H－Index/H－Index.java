import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int n = citations.length;
        
        Arrays.sort(citations);
        
        for(int i=1; i<=n; i++){
            int less = findLessThanH(citations, i);
            int more = n - (findMoreThanH(citations, i) + 1);
            
            if(less <= i && more>=i) {
                answer = i;
            }
        }
            
        
        return answer;
    }
    private int findMoreThanH(int [] arr, int h) {
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right) {
            int mid = (left+right) / 2;
            
            
            if(arr[mid] >= h) {
                right = mid-1;
            } else {
                left = mid +1;
            }
        }
        return right;
    }
    
    private int findLessThanH(int [] arr, int h) {
        int left = 0;
        int right = arr.length-1;
        
        while(left <= right) {
            int mid = (left+right) / 2;

            if(arr[mid] <= h) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}