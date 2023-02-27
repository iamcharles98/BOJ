import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N;
        int M;
        int V;
        N = scanner.nextInt();
        M = scanner.nextInt();
        V = scanner.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0;i<N;i++)
        {
            graph.add(new ArrayList<>());
        }
       int x ,y;
        for (int i = 0; i < M; i++) {
            x= scanner.nextInt()-1;
            y= scanner.nextInt()-1;
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        dfs(graph, V-1);
        bufferedWriter.write("\n");
        bfs(graph, V-1);

        return ;
    }
    public static void bfs(ArrayList<ArrayList<Integer>> graph, int start) throws IOException {
        boolean[] visited = new boolean[graph.size()];
        for(int i=0;i< visited.length;i++)
        {
            visited[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty())
        {
            int node = queue.poll();
            if(visited[node]==false) {
                bufferedWriter.append(node+1 + " ");
                ArrayList<Integer> connect = graph.get(node);
                Collections.sort(connect);
                for(int i =0; i< connect.size();i++)
                {
                    queue.add(connect.get(i));
                }
                visited[node]=true;
            }
        }
        bufferedWriter.flush();
    }
    public static void dfs( ArrayList<ArrayList<Integer>> graph, int start) throws IOException {
        boolean[] visited = new boolean[graph.size()];
        for(int i=0;i< visited.length;i++)
        {
            visited[i] = false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty())
        {
            int node = stack.pop();
            if(visited[node]==false) {
                ArrayList<Integer> connect = graph.get(node);
                Collections.sort(connect, Collections.reverseOrder());
                bufferedWriter.append(node+1 + " ");
                for (int i = 0; i < connect.size(); i++) {
                    stack.push(connect.get(i));
                }
                visited[node] = true;
            }

            bufferedWriter.flush();
        }
    }
}
