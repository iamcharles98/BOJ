import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static Map<String, Integer> answerCode = new HashMap<>();
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        answerCode.put("0001101", 0);
        answerCode.put("0011001", 1);
        answerCode.put("0010011", 2);
        answerCode.put("0111101", 3);
        answerCode.put("0100011", 4);
        answerCode.put("0110001", 5);
        answerCode.put("0101111", 6);
        answerCode.put("0111011", 7);
        answerCode.put("0110111", 8);
        answerCode.put("0001011", 9);
        StringBuilder stringBuilder = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            String[] code = new String[row];
            for (int i = 0; i < row; i++) {
                code[i] = sc.next();
            }
            String binaryCode = findCode(code);
            stringBuilder.append("#").append(test_case).append(" ").append(checkCode(binaryCode)).append("\n");
        }
        System.out.println(stringBuilder.toString());
	}
    private static int checkCode(String binaryCode) {
        int[] nums = new int[8];
        int idx = 0;
        for (int i = 0; i < binaryCode.length(); i += 7) {
            nums[idx++] = match(binaryCode.substring(i,i+7));
        }
        return decode(nums);
    }

    private static int decode(int[] nums) {

        int oddSum = 0;
        int evenSum = 0;
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                oddSum += nums[i];
                continue;
            }
            evenSum += nums[i];
        }
        if (((oddSum * 3) + evenSum) % 10 == 0) {
            return evenSum + oddSum;
        }
        return 0;
    }

    private static int match(String copyOfRange) {
        return answerCode.get(copyOfRange);
    }

    private static String findCode(String[] code) {
        String binaryCode = "";
        boolean find = false;
        for (int i = 0; i < code.length; i++) {
            if (find) {
                break;
            }
            for (int j = code[i].length() - 1; j >= 0; j--) {
                if (code[i].charAt(j) == '1') {
                    binaryCode = code[i].substring(j-55,j+1);
                    find = true;
                    break;
                }
            }
        }
        return binaryCode;
    }
}