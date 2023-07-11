

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static List<List<Integer>> relation = new ArrayList<>();
    static Integer [] kevinNum ;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        kevinNum = new Integer[N+1];
        for (int j=0;j<=N;j++)
            kevinNum[j]=0;

        for(int i =0; i<=N;i++)
            relation.add(new ArrayList<>());
        for(int i =0;i<M;i++)
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            relation.get(x).add(y);
            relation.get(y).add(x);
        }

        int answer = solution();
        System.out.println(answer);
    }
    private static int solution() {
        for(int i = 1; i<=N;i++)
        {
            for(int j =1; j<=N;j++)
            {
                kevinNum[i] += findKevinNum(i,j);
            }
        }
        int min=Integer.MAX_VALUE;
        int idx =0;
        for(int i = 1 ; i<=N;i++)
            if(min>kevinNum[i]) {
                min = kevinNum[i];
                idx = i;
            }
        return idx;
    }

    private static int findKevinNum(int i, int j) {
        int result = 1;
        if(i==j)return 0;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(relation.get(i));
        boolean [] visit = new boolean[N+1];
        visit[i] = true;
        while (true) {
            int size = queue.size();
            for(int z=0;z<size;z++) {
                List<Integer> cur_relation = queue.poll(); //현재의 친구리스트를 가져옴
                if (cur_relation.contains(j)) return result; // 친구리스트에 찾는사람 없으면
                for (int num : cur_relation) //친구리스트의 친구리스트를 담는다.
                {
                    if (!visit[num]) {
                        queue.add(relation.get(num));
                        visit[num] = true;
                    }
                }
            }
            result++;
        }
    }
}
