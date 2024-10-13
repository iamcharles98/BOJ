import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    
    static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        recur(new ArrayList<>(), arr);
        System.out.print(sb.toString());
    }

    static void recur(List<Integer> picked, int[] arr) {
        if (picked.size() == M) {
            for (int num : picked) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int num : arr) {
            if (!picked.contains(num)) {
                List<Integer> newPicked = new ArrayList<>(picked);
                newPicked.add(num);
                recur(newPicked, arr);
            }
        }
    }

}
