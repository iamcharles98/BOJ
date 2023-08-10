import java.util.HashMap;
import java.util.Map;
class Solution {
    private static final int COMMISSION = 10;
    private static final int BRUSH_PRICE = 100;
    public int[] solution(String[] enroll, String[] referral, String[] sellers, int[] amount) {
                int[] answer = new int[enroll.length];
        Map<String, Integer> index = new HashMap<>();
        Map<String, String> relation = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
//            판매자들의 인덱스를 설정
            index.put(enroll[i], i);
//            각 판매자의 부모를 설정
            relation.put(enroll[i], referral[i]);
            answer[i] = 0;
        }

//        sellers로 부터 판매한 사람들을 입력받는데 판매한 사람들은 자신의 수익의 10%를 수수료로 부모에게 지불해야한다.

        for (int i = 0; i < sellers.length; i++) {
            String curSeller = sellers[i];

            int profit = BRUSH_PRICE * amount[i];
            int commissionForParent = profit / COMMISSION;
            answer[index.get(curSeller)] += (profit - commissionForParent);

            while (!relation.get(curSeller).equals("-")) {
                String parent = relation.get(curSeller);
                answer[index.get(parent)] += (commissionForParent - commissionForParent / COMMISSION);
                commissionForParent /= COMMISSION;
                if (commissionForParent < 1) {
                    break;
                }
                curSeller = parent;
            }
        }
        return answer;
    }
    }