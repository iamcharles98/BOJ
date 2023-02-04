

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int Testcase;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stringTokenizer;
    static int start_x;
    static int start_y;
    static int end_x;
    static int end_y;

    public static void main(String[] args) throws IOException {

        int planet;
        List<circle> circles = new ArrayList<>();
       Testcase = Integer.parseInt(bufferedReader.readLine());

       int [] results = new int[Testcase];
       for(int i=0; i<Testcase;i++)
       {
           int count =0;
           stringTokenizer= new StringTokenizer(bufferedReader.readLine());
           start_x = Integer.parseInt(stringTokenizer.nextToken());
           start_y = Integer.parseInt(stringTokenizer.nextToken());
           end_x = Integer.parseInt(stringTokenizer.nextToken());
           end_y = Integer.parseInt(stringTokenizer.nextToken());
           planet = Integer.parseInt(bufferedReader.readLine());
           for(int j=0;j<planet;j++)
           {
               int x,y,r;
               stringTokenizer= new StringTokenizer(bufferedReader.readLine());
               x = Integer.parseInt(stringTokenizer.nextToken());
               y = Integer.parseInt(stringTokenizer.nextToken());
               r = Integer.parseInt(stringTokenizer.nextToken());
               circles.add(new circle(x,y,r));
               if(circles.get(j).IsInCircle(start_x,start_y))count++;
               if(circles.get(j).IsInCircle(end_x,end_y))count++;
               if(circles.get(j).IsInCircle(end_x,end_y)&&circles.get(j).IsInCircle(start_x,start_y))
                   count-=2;
           }
           circles.clear();
           results[i]=count;
       }
       for(int i=0;i<Testcase;i++)
       {
           System.out.println(results[i]);
       }
    }

    static class circle
    {
        int c_x;
        int c_y;
        int r;
        public circle(int x, int y, int r)
        {
            this.c_x=x;
            this.c_y=y;
            this.r=r;
        }

        public boolean IsInCircle(int x, int y)
        {
            int X = (this.c_x>x) ? this.c_x-x : x-this.c_x;
            int Y = (this.c_y>y) ? this.c_y-y : y-this.c_y;
            if(r*r>(X*X)+(Y*Y))
            {
                return true;
            }
            else return false;
        }
    }
}
