

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    static StringTokenizer stringTokenizer ;
    static ArrayList<Link> [] tree;
    static class Link{
        int link;
        int weight;
        public Link(int link, int weight) {
            this.link = link;
            this.weight = weight;
        }
    }
    static ArrayList<Integer> leaf = new ArrayList<>();
    static boolean [] visit;
    static int max=0;

    public static void main(String[] args) throws IOException {
        N  = Integer.parseInt(bufferedReader.readLine());
        tree = new ArrayList[N+1];
       for(int i = 1; i<=N;i++)
       {
           tree[i] = new ArrayList<>();
       }
        for (int i =1 ; i<N ; i++)
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int parent;
            int child;
            int weight;
            parent = Integer.parseInt(stringTokenizer.nextToken());
            child = Integer.parseInt(stringTokenizer.nextToken());
            weight = Integer.parseInt(stringTokenizer.nextToken());
            tree[parent].add(new Link(child,weight));
            tree[child].add(new Link(parent,weight));
        }
        for(int i = 1 ; i<N;i++)
        {
            if(tree[i].size()<2)
            {
                leaf.add(i);
            }
        }

        sol();

    }

    private static void sol() {

        for(int i = 0; i < leaf.size(); i++)
        {
            visit = new boolean[N+1];
            int idx = leaf.get(i);
            visit[idx]= true;
            dfs(idx,0,idx);
        }
        System.out.println(max);
    }

    private static void dfs(int idx, int sum, int start) {
        if(tree[idx].size()<2 && start!=idx)
        {
            max = (sum > max)? sum : max;
            return;
        }

        for(int i =0; i<tree[idx].size();i++)
        {
            int next = tree[idx].get(i).link;
            if(visit[next]==false)
            {
                visit[next]=true;
                dfs(next,sum+tree[idx].get(i).weight, start);
            }
        }
    }
}
