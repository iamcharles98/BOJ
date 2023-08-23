import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static List<Integer> set;
    static Set<Integer> visit;
    static int[] arr;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {


        while (true) {
            String input = bufferedReader.readLine();
            if (input.equals("0")) {
                break;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(input);
            k = Integer.parseInt(stringTokenizer.nextToken());
            set = new ArrayList<>();
            arr = new int[6];
            visit = new HashSet<>();

            for (int i = 0; i < k; i++) {
                set.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            recur(0, 0);
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);

    }

    private static void recur(int depth, int idx) {
        if (depth == 6) {
            for (int i : arr) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = idx; i < set.size(); i++) {
            int num = set.get(i);
            if (!visit.contains(num)) {
                visit.add(num);
                arr[depth] = num;
                recur(depth + 1, i);
                visit.remove(num);

            }
        }
    }
}
