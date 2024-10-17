import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    
    static int N;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int idx = binary(arr[i], sorted);
            if(idx == sorted.size()) {
                sorted.add(arr[i]);
            } else {
                sorted.set(idx, arr[i]);
            }
        }

        System.out.println(sorted.size());
    }

    public static int binary(int target, List<Integer> arr) {
        if(arr.isEmpty()) return 0;
        int left = 0;
        int right = arr.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) < target) {
                left = mid + 1;
            } else if (arr.get(mid) >= target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
