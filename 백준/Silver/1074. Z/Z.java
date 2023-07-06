
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int count =0;
    static int N,R,C;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());
        R = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        int size = (int) Math.pow(2,N);
        find(0,0,size);
    }

    static public void find(int r, int c,int size)
    {
        if(size==1)
        {
            System.out.println(count);
            return;
        }

        int newSize = size/2;
        if(R < r+newSize && C < c+ newSize)
            find(r,c,newSize);
        if(R < r + newSize && C >= c + newSize)
        {
            count += (size*size)/4;
            find(r, c+newSize, newSize);
        }
        if(R>= r + newSize && C < c + newSize)
        {
            count += ((size*size)/4)*2;
            find(r+newSize, c ,newSize);
        }
        if(R>= r + newSize && C >= c + newSize)
        {
            count += ((size*size)/4)*3;
            find(r+newSize, c+newSize, newSize);
        }
    }
}
