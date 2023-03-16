import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int N=0;

    public static void main(String[] args) {
        N = scanner.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int i =0; i<N;i++)
        {
         pq.add(scanner.nextLong());
        }

        long result = solution(pq);
        System.out.println(result);
    }
    public static long solution(PriorityQueue<Long> pq)
    {
       if(pq.size()==1) return 0;
       long result=0;
       while (pq.size()!=1) {
          Long min1 = pq.poll();
          Long min2 = pq.poll();
          pq.add(min1+min2);
          result+= (min1+min2);
           }
        return result;
    }
}
