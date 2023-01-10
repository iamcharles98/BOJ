import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int [][] items = new int[N][2];
		for(int i=0;i<N;i++)
		{
			items[i][0]=sc.nextInt();
			items[i][1]=sc.nextInt();
		}
		
		int [][] cost_Table = new int[N+1][K+1];
		for(int i=0;i<cost_Table[0].length;i++)
		{
			cost_Table[0][i]=0;
		}
		int answer = get_sol(items,cost_Table);
		System.out.println(answer);
		
	}

	public static int get_sol(int items[][], int table[][])
	{
		int answer=0;
		for(int i=1;i<table.length;i++) 
		{
		for(int j=0;j<table[0].length;j++)
		{
			if(items[i-1][0]>j)
			{
				table[i][j]=table[i-1][j];
			}
			else
			{
				table[i][j]=(table[i-1][j]>table[i-1][j-items[i-1][0]]+items[i-1][1]) ? table[i-1][j] : table[i-1][j-items[i-1][0]]+items[i-1][1];   
			}
		}
		}
		answer = table[table.length-1][table[0].length-1];
		return answer;
	}
}
