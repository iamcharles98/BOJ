import java.util.*;
class Solution {

    static HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        // HashSet을 통해 모든 숫자 조합을 만듦
        recursive("", numbers);

        // numbers의 숫자만큼 최대수 갱신
        String s_maxVal = "";
        for (int i = 0 ; i < numbers.length() ; i++) {
            s_maxVal += "9";
        }
        int maxVal = Integer.parseInt(s_maxVal);

        // 에라토스테네스의 체
        int S[] = new int[maxVal + 1];
        for (int i = 2 ; i < S.length ; i++) {
            S[i] = i;
        }
        for (int i = 2 ; i < Math.sqrt(S.length) ; i++) {
            if (S[i] == 0) {
                continue;
            }
            for (int j = i + i ; j < S.length ; j = i + j) {
                S[j] = 0;
            }
        }

        // HashSet에 저장된 값을 체에 걸러 값이 0이 아니면 answer++
        for (int x : numberSet) {
            if (S[x] != 0) {
                answer++;
            }
        }

        return answer;
    }

    // 숫자 조합을 만드는 재귀함수
    static void recursive(String comb, String other) {
        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }

        for (int i = 0 ; i < other.length() ; i++) {
            recursive(comb + other.charAt(i), other.substring(0,i) + other.substring(i+1));
        }

    }

}
// class Solution {
//     static int squareRoot = 50000;
//     static boolean[] sieve = new boolean[10000000];
    
    
//     public int solution(String numbers) {
//         int answer = 0;
//         makeSieve();
//         String[] perNum = numbers.split("");
        
//         answer = makeNumByDigitAndNumbers(perNum);
//         return answer;
//     }
    
//     private int makeNumByDigitAndNumbers(String[] numbers) {
//         int count = 0;
//         Set<Integer> set = new HashSet<>();
//         for(int digit = 1 ; digit<=numbers.length; digit++) {
//             Set<Integer> used = new HashSet<>();
//             dfs(used, "", digit, set, numbers);
//         }
//         count = countOfPrime(set);
//         return count;
//     }
    
//     private int countOfPrime(Set<Integer> nums) {
//         int cnt = 0;
//         for(int num : nums) {
//             if(isPrime(num)) {
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
    
//     private void dfs(Set<Integer> used, String makedNum, int limit, Set<Integer> set, String[] numbers) {
//         if(makedNum.length() == limit) {
//             set.add(Integer.parseInt(makedNum));
//             return;
//         }
//         for(int i=0; i<numbers.length; i++) {
//             if(!used.contains(i)) {
//                 used.add(i);
//             dfs(used, makedNum + numbers[i], limit, set, numbers);
//                 used.remove(i);
//             }
//         }
//     }
//     private boolean isPrime(int num) {
//         return sieve[num];
//     }
    
//     private void makeSieve() {
//         Arrays.fill(sieve, true);
//         sieve[0] = false;
//         sieve[1] = false;
        
//         for(int i=2; i<=squareRoot; i++) {
//             if(sieve[i] == false) {
//                 continue;
//             }
            
//             for(int j= i*2; j<sieve.length; j+=i) {
//                 sieve[j] = false;
//             }
//         }
//     }
    
// }