import java.util.*;
class Solution {
    /*
    0 또는 양의 정수가 담긴 배열에서 가장 큰 수 만들기
    
    numbers의 길이 1 <= length <= 100,000
    0 <= numbers[i] <= 1,000
    
    [3, 30, 34, 5, 9]
    3, 30, 34 중 어떻게 선택 ?
    9, 5, 34, 3, 30
    
    9 ~ 0 까지 우선순위에 따라 선택해서 붙히기
    
    9, 99, 98, 95, 986, 977, 953, 912 있을 때
    
    9 선택
    99 선택
    98 선택
    986 선택
    977 선택
    95
    953
    912
    
    
    1 부터 9 까지 배열 생성
    각 배열마다 정렬 -> 자릿수가 큰 순으로
    Ex) 9 배열에 [9, 99, 98, 95, 986, 977, 953, 912] 있으면
    [9, 99, 98, 986, 977, 95, 953, 912] 로 정렬
    
    자리수로 정렬하는 함수 필요
    
    
    */
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        Map<Integer, List<Integer>> table = new HashMap<>();
        
        for(int i=0;i<10;i++) {
            table.put(i, new ArrayList<>());
        }
        
        for(int i=0; i<numbers.length; i++) {
            table.get(getRepresentNum(numbers[i])).add(numbers[i]);
        }
        
        /*for(int i : table.keySet()) {
            System.out.println(i + " : " + table.get(i));
        }*/
        for(int key : table.keySet()) {
            sortTable(table.get(key));
        }
        
        for(int i=9;i>=0;i--) {
            for(int num : table.get(i)) {
                answer.append(Integer.toString(num));
            }
        }
        if(table.get(0).size() == numbers.length) {
            return "0";
        }
        return answer.toString();
    }
    private static void sortTable(List<Integer> list) {
       
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer f1, Integer f2) {
                return (String.valueOf(f2) + String.valueOf(f1)).compareTo(String.valueOf(f1) + String.valueOf(f2));
            }
        });
        //System.out.println(list);
        return;
    }
    private static int getRepresentNum(int num) {
        int digit = 0;
        
        while(num > 0) {
            digit = num%10;
            num /= 10;
        }
        
        return digit;
    }
}