import java.util.*;

class Solution {
    /*
    유사한 기사를 묶기
    유사도 검사 -> 자카드 유사도
    J(A, B) -> A, B의 교집합 크기 / A, B의 합집합 크기
    A, B가 공집합일 경우 1 반환
    중복된 원소를 포함하고 있는 집합 C, D에 대해
    C 교집합 D => 같은원소에 대해 min 갯수
    C 합집합 D => 같은원소에 대해 max 갯수
    */
    Map<String, Integer> set1 = new HashMap<>();
    Map<String, Integer> set2 = new HashMap<>();
    Set<String> allKey = new HashSet<>();
    final double BASE = 65536;
    final String REGEX = "^[a-z]*$";
    public double solution(String str1, String str2) {
        str1 = preTreatment(str1);
        str2 = preTreatment(str2);
        
        for(int i=0; i<=str1.length() - 2; i++) {
            String ele = str1.substring(i,Math.min(i+2, str1.length()));
            if(ele.matches(REGEX)) {
                set1.put(ele, set1.getOrDefault(ele,0)+1);
                allKey.add(ele);
            }
        }
        for(int i=0; i<=str2.length() - 2; i++) {
            String ele = str2.substring(i,Math.min(i+2, str2.length()));
            if(ele.matches(REGEX)) {
                set2.put(ele, set2.getOrDefault(ele,0)+1);
                allKey.add(ele);
            }
        }
        if(set1.isEmpty() && set2.isEmpty()) {
            return BASE;
        }
        return jacard();
    }
    
    private String preTreatment(String string) {
        return string.toLowerCase();
    }
    private double jacard() {
        int c = getCommon();
        int s = getSum();
        double j = (double)c/(double)s;
        return Math.floor(j * BASE) ;
    }
    private int getCommon() {
        int result = 0;
        for(String ele1 : set1.keySet()) {
            int numOfEle1 = set1.get(ele1);
            if(set2.containsKey(ele1)) {
                int numOfEle2 = set2.get(ele1);
                result += Math.min(numOfEle1, numOfEle2);
            }
        }
        return result;
    }
    private int getSum() {
        int result = 0;
        for(String key : allKey) {
            boolean f1 = set1.containsKey(key);
            boolean f2 = set2.containsKey(key);
            if(f1 && f2) {
                result += Math.max(set1.get(key), set2.get(key));
                continue;
            }
            if(f1) {
                result += set1.get(key);
                continue;
            }
            result+=set2.get(key);
        }
        return result;
    }
}