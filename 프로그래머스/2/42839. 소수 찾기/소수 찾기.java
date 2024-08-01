import java.util.*;

class Solution {
    static int squareRoot = 50000;
    static boolean[] sieve = new boolean[10000000];
    
    
    public int solution(String numbers) {
        int answer = 0;
        makeSieve();
        String[] perNum = numbers.split("");
        
        answer = makeNumByDigitAndNumbers(perNum);
        return answer;
    }
    
    private int makeNumByDigitAndNumbers(String[] numbers) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int digit = 1 ; digit<=numbers.length; digit++) {
            Set<Integer> used = new HashSet<>();
            dfs(used, "", digit, set, numbers);
        }
        count = countOfPrime(set);
        return count;
    }
    
    private int countOfPrime(Set<Integer> nums) {
        int cnt = 0;
        for(int num : nums) {
            if(isPrime(num)) {
                cnt++;
            }
        }
        return cnt;
    }
    
    private void dfs(Set<Integer> used, String makedNum, int limit, Set<Integer> set, String[] numbers) {
        if(makedNum.length() == limit) {
            set.add(Integer.parseInt(makedNum));
            return;
        }
        for(int i=0; i<numbers.length; i++) {
            if(!used.contains(i)) {
                used.add(i);
            dfs(used, makedNum + numbers[i], limit, set, numbers);
                used.remove(i);
            }
        }
    }
    private boolean isPrime(int num) {
        return sieve[num];
    }
    
    private void makeSieve() {
        Arrays.fill(sieve, true);
        sieve[0] = false;
        sieve[1] = false;
        
        for(int i=2; i<=squareRoot; i++) {
            if(sieve[i] == false) {
                continue;
            }
            
            for(int j= i*2; j<sieve.length; j+=i) {
                sieve[j] = false;
            }
        }
    }
    
}