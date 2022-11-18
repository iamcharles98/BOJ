import java.util.Scanner;

public class Main {
    static int [][] field;
    static boolean [][] visited;

    static int total;

    static int worm;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T;
        int M;
        int N;
        int K;
        T =scanner.nextInt();
        for(int z =0;z<T;z++) {
            M = scanner.nextInt();
            N = scanner.nextInt();
            K = scanner.nextInt();
            field = new int[M][N];
            visited = new boolean[M][N];
            total = K;
            worm=0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    field[i][j] = 0;
                    visited[i][j] = false;
                }
            }
            for (int i = 0; i < K; i++) {
                int x;
                int y;
                x = scanner.nextInt();
                y = scanner.nextInt();
                field[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                if (total == 0) break;
                for (int j = 0; j < N; j++) {
                    if (field[i][j] == 1 && visited[i][j] == false) {
                        trap(i, j);
                        worm++;
                    }
                }
            }
            System.out.println(worm);
        }
        return;
    }
    static void trap(int i, int j)
    {
        if(visited[i][j]==false && field[i][j]==1)
        {
            visited[i][j]=true;
            total--;
            if(i-1>=0)trap(i-1,j);
            if(i+1< visited.length)trap(i+1,j);
            if(j-1>=0)trap(i,j-1);
            if(j+1< visited[0].length)trap(i,j+1);

        }
        return;
    }
}
