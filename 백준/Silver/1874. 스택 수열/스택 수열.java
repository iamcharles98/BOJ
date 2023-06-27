

import java.io.*;
import java.util.Stack;

public class Main {
    static Stack<Integer> stack = new Stack<>();
    static int cur_push = 1;

    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        N = Integer.parseInt(bufferedReader.readLine());
        int [] nums = new int[N];

        for(int i=0;i<N;i++)
        {
            nums[i] = Integer.parseInt(bufferedReader.readLine());
        }


        for(int num : nums)
        {
            String result = CheckPossible(num);
            if(result.equals("Impossible"))
            {
                System.out.println("NO");
                return;
            }
            else
            {
                stringBuilder.append(result);
            }
        }

        System.out.print(stringBuilder.toString());
        return;
    }
    static String CheckPossible(int num)
    {
        String result = "";

        if(cur_push == num)
        {
          // 현재 푸쉬하려는 값과 num이 같다면 push했다가 pop해주면서 num을 생성한다.
          // 따라서 + 와 -를 result로 반환한다.
            cur_push++;
            result = "+\n-\n";
        }
        else if(cur_push < num)
        {
            //현재 푸쉬하려는 값보다 num값이 큰 경우 num을 만들기 위해 num보다 작은 값을 모두 push한다.
            while (cur_push != num)
            {
                stack.push(cur_push++);
                result+="+\n";
            }
            cur_push++;
            result+="+\n-\n";
        }
        else
        {
            //현재 푸쉬하려는 값보다 num값이 작은 경우
            if(stack.peek() != num)
            {
                result = "Impossible";
            }
            else
            {
                stack.pop();
                result = "-\n";
            }
        }
        return result;
    }
}
