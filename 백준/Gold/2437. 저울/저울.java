import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int [] canMeasure = new int [2];
    static List<Integer> weights = new ArrayList<>();
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int idx = 0; idx < N; idx++) {
            int w = Integer.parseInt(stringTokenizer.nextToken());
            weights.add(w);
        }
        Collections.sort(weights);
        for(int weight : weights) {
            int min = canMeasure[0] + weight;
            if(canMeasure[1] + 1 < min) {
                answer = canMeasure[1] + 1;
                break;
            }
            canMeasure[1] = canMeasure[1] + weight;

        }
        if(answer==0) {
            answer = canMeasure[1]+1;
        }
        System.out.println(answer);
    }

}
