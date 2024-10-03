import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        int [] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        //오름차순 정렬

        for(int i=0; i<N; i++) {
            int l = 0;
            int r = arr.length-1;
            while(l<r) {
                long sum = arr[l] + arr[r];
                if(sum > arr[i]) {
                    r--;
                } else if(sum < arr[i]) {
                    l++;
                } else {
                    if(l!=i && r!=i) {
                        ans++;
                        break;
                    } else if (i==l) {
                        l++;
                    }
                    else {
                        r--;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
