import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static ArrayDeque<Integer>[] graph;
	static int[] visited;
	static int k;
	static int x;
	static ArrayList<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		graph = new ArrayDeque[n+1];
		visited = new int[n+1];
		Arrays.fill(visited, -1);
		
		for(int i=1; i<=n; i++) {
			graph[i] = new ArrayDeque<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].addLast(b);
		}
		
		BFS();
		
		if(answer.size() == 0) {
			System.out.println(-1);
		} else {
			Collections.sort(answer);
			for(int ans : answer) {
				System.out.println(ans);
			}
		}
	}
	
	public static void BFS() {
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		queue.addLast(x);
		visited[x] = 0;
		
		while(!queue.isEmpty()) {
			int now = queue.pollFirst();
			if(visited[now] > k) break;
			if(visited[now] == k) {
				answer.add(now);
			}
			
			for(int next : graph[now]) {
				if(visited[next] != -1) continue;
				queue.addLast(next);
				visited[next] = visited[now] + 1;
			}
		}
	}
}