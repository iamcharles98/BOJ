

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    문제
    자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
    고른 수열은 오름차순이어야 한다.
    
    입력
    첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

    출력
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며,
    각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.

    오름차순 이여야 한다. -> 이전에 고른 수를 재귀 호출에서 알고있어야 함
     */
    static int N, M;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder stringBuilder = new StringBuilder();

    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        visit = new boolean[N + 1];
        arr = new int[M];

        recur(0,0);

        System.out.print(stringBuilder);
    }

    private static void recur(int depth, int num) {
        if (depth == M) {
            for (int i : arr) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
            return;
        }

        for (int i = num + 1; i <= N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = i;
                recur(depth+1,i);
                visit[i] = false;
            }
        }
    }
}
