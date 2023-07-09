
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N=0;
    static int M=0;
    static Integer [] set;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N =Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        set = new Integer[N + 1];
        for(int i=1;i<set.length;i++)
            set[i]=i;
        int node1=0 , node2 = 0;
        for(int i =0; i< M ; i++)
        {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            node1 = Integer.parseInt(stringTokenizer.nextToken());
            node2 = Integer.parseInt(stringTokenizer.nextToken());
            makeSet(node1,node2);
        }
        List<Integer> root = new ArrayList<>();
        for(int i=1;i<set.length;i++)
        {
            int num = find(set[i]);
            if(root.isEmpty()) {
                root.add(num);
                continue;
            }
            if(!root.contains(num))
            {
                root.add(num);
            }
        }
        System.out.println(root.size());
    }
    public static void makeSet(int node1, int node2)
    {
       node1 = find(node1);
       node2 = find(node2);

       if(node1==node2) return ;

       if(node1<= node2) set[node2] = node1;
       else set[node1] = node2;
       return ;
    }

    public static int find(int node1)
    {
        if(set[node1]==node1) return node1;
        return find(set[node1]);

    }



}
