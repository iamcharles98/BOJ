import java.util.*;
class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        List<String> numberList = parseStringToSet(s);
        for(String num : numberList) {
            StringTokenizer st = new StringTokenizer(num);
            while(st.hasMoreTokens()) {
                int n = Integer.parseInt(st.nextToken());
                if(!answer.contains(n)){
                    answer.add(n);
                }
            }
        }
        return answer;
    }
    
    private static List<String> parseStringToSet(String s) {
        String numberSet = s.substring(1,s.length()-1);
        List<String> numbers = new ArrayList<>();
        int startIdx = 0;
        for(int idx = 0; idx<numberSet.length(); idx++) {
            if(numberSet.charAt(idx) == '}') {
                numbers.add(numberSet.substring(startIdx, ++idx).replaceAll("[{}]","").replaceAll(","," "));
                startIdx = idx+1;
            }
        }
        Collections.sort(numbers,new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        return numbers;
    }
}