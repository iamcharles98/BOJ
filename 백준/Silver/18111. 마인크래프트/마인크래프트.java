
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int flat_height = 0;
    static int answer_time = Integer.MAX_VALUE;
    static int answer_height = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int N;
        int M;
        int B;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());
        int [][] land = new int[N][M];
        int min_height = Integer.MAX_VALUE;
        int max_height = Integer.MIN_VALUE;
        for(int i =0;i<N;i++)
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<M;j++)
            {
                land[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(land[i][j]<min_height) min_height = land[i][j];
                if(land[i][j]>max_height) max_height = land[i][j];
            }
        }


        // 최소 높이부터 시작해서 높이를 하나씩 높여가면서 평탄화
        for(int cur_height = min_height; cur_height<=max_height;cur_height++)
        {
            int time = 0;
            int inventory  = B;
            for(int n = 0; n<N; n++)
            {
                for(int m =0;m<M;m++)
                {
                    if(cur_height<land[n][m])
                    {
                        //땅의 높이가 평탄화 시킬 높이보다 높다면 블록제거 작업 실시//
                        int working = land[n][m] - cur_height;
                        time += 2*working;
                        inventory += working;
                        continue;
                    }
                    inventory -= (cur_height - land[n][m]);
                    time+= (cur_height - land[n][m]);
                }
            }
            if(inventory<0)break;
            if(time<=answer_time) {
                answer_time = time;
                answer_height = cur_height;
            }

        }
        System.out.println(answer_time+" "+answer_height);

    }
}
