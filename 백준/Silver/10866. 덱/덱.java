

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(bufferedReader.readLine());

        for(int i =0;i<N;i++)
        {
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            String order = st.nextToken() ;
            if(order.equals("size")) {
                stringBuilder.append(Integer.toString(deque.size())+"\n");
                continue;
            }
            if(order.equals("empty"))
            {
                if(deque.isEmpty()) stringBuilder.append(Integer.toString(1)+"\n");
                else stringBuilder.append(Integer.toString(0)+"\n");
                continue;
            }
            if(order.equals("front"))
            {
                if(deque.isEmpty()) {
                    stringBuilder.append(Integer.toString(-1) + "\n");
                }else {
                    stringBuilder.append(Integer.toString(deque.peek()) + "\n");
                }
                continue;
            }
            if(order.equals("back"))
            {
                if(deque.isEmpty()) {
                    stringBuilder.append(Integer.toString(-1) + "\n");
                }else {
                    stringBuilder.append(Integer.toString(deque.peekLast()) + "\n");
                }
                continue;
            }
            if(order.equals("push_front"))
            {
                int num = Integer.parseInt(st.nextToken());
                deque.offerFirst(num);
                continue;
            }
            if(order.equals("push_back"))
            {
                int num = Integer.parseInt(st.nextToken());
                deque.offerLast(num);
                continue;
            }
            if(order.equals("pop_front"))
            {
                if(deque.isEmpty()) {
                    stringBuilder.append(Integer.toString(-1) + "\n");
                }
                else
                {
                    int num = deque.pollFirst();
                    stringBuilder.append(Integer.toString(num) + "\n");
                }
                continue;
            }
            if(order.equals("pop_back"))
            {
                if(deque.isEmpty()) {
                    stringBuilder.append(Integer.toString(-1) + "\n");
                }
                else
                {
                    int num = deque.pollLast();
                    stringBuilder.append(Integer.toString(num) + "\n");
                }
            }

        }
        bufferedWriter.write(stringBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
        return;
    }
}
