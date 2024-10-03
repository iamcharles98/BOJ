import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans= Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        if(arr[N]<S) {
            System.out.println(0);
            return;
        }

        int l=0;
        int r=1;
        while(r<=N && l<r) {
            if(arr[r]-arr[l] >= S) {
                ans = Math.min(ans, r-l);
                l++;
            } else {
                r++;
            }
        }

        System.out.println(ans);
    }
}
