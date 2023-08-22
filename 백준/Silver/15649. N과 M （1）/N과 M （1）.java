
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        int N, M;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());


        List<Integer> list = new ArrayList<>();

        recur(list, 0, M, N);


    }

    private static void recur(List<Integer> visit, int cnt, int M, int N) {

         if (cnt == M) {
            for(int i : visit) {
                System.out.print(i+" ");
            }
            System.out.println("");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visit.contains(i)) {
                visit.add(i);
                recur(visit, cnt + 1, M, N);
                visit.remove(visit.indexOf(i));
            }
        }
    }

}
