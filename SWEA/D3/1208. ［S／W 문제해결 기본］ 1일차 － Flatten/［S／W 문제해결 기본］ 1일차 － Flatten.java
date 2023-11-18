import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int diff = 0;
            int dumpTry = sc.nextInt();
            List<Integer> boxes = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                boxes.add(sc.nextInt());
            }
            while (dumpTry >= 0) {
                int min = boxes.stream().min(Integer::compareTo).get();
                int max = boxes.stream().max(Integer::compareTo).get();
                diff = max - min;
                if (diff == 0 || diff == 1) {
                    break;
                }

                boxes.remove(boxes.indexOf(max));
                boxes.add(max - 1);
                boxes.remove(boxes.indexOf(min));
                boxes.add(min + 1);
                dumpTry--;
            }

            System.out.println("#" + test_case +" "+ diff);
        }
	}
}