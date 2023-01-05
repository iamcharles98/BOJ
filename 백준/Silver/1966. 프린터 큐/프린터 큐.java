

import java.util.*;

public class Main {

    static int t;
    static int N;
    static int M;
    static Queue<Integer> queue;
    static Queue<Integer> idx ;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        t= scanner.nextInt();
        for(int i=0;i<t;i++)
        {
            N = scanner.nextInt();
            M = scanner.nextInt();
            queue = new LinkedList<>() ;
            idx = new LinkedList<>();
            for(int j=0;j<N;j++)
            {
                int priority = scanner.nextInt();
                queue.offer(priority);
                idx.offer(j);
            }
            System.out.println(solution());
        }
    }

    public static int solution()
    {
        int cnt =1;
        int target = M;
        int cur_priority;
        int cur_idx;
        int max_priority;
        while(queue.isEmpty()==false)
        {
            cur_priority = queue.peek();
            max_priority = Collections.max(queue);
            cur_idx = idx.peek();
            if(cur_priority==max_priority)
            {
                if(cur_idx==target) break;
                else {
                    queue.poll();
                    idx.poll();
                    cnt++;
                }
            }
            else {
                queue.poll();
                queue.offer(cur_priority);
                idx.poll();
                idx.offer(cur_idx);
            }
        }
        return cnt;
    }
}
