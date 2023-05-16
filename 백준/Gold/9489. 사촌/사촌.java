

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        while (true)
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());
            if(N == 0 && K == 0) break;
            sb.append(sol(N,K,bufferedReader.readLine()));
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static int sol(int n, int k, String readLine) {
        int [] arr = new int[n+1];
        int kidx =0;
        stringTokenizer = new StringTokenizer(readLine);
        for(int i = 1; i<=n;i++)
        {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
            if(arr[i]==k)
                kidx=i;
        }
        int [] parent = new int[n+1];
        int idx= -1;
        parent[0] = -1;
        arr[0] = -1;

        //1 3 4 5 8 9 15 30 31 32
        for(int i =1 ;i<=n;i++)
        {
                if(arr[i-1]+1 != arr[i])
                    idx++;
                parent[i]=idx;
        }
        int count = 0;
        for(int i = 1; i<=n;i++)
        {
            if(parent[parent[kidx]]==parent[parent[i]] && parent[kidx] != parent[i])
                count++;
        }

        return count;
        }


    }



