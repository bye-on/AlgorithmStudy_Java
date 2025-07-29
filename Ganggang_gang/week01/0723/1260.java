import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[][] graph;
	static int n;
	static int k;
	
	
	
	
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		graph = new int[n+1][n+1];
		
		for(int i =0; i<k; i++) {
			StringTokenizer val = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(val.nextToken());
			int y = Integer.parseInt(val.nextToken());
			graph[x][y] = graph[y][x] = 1;
			
		}
		int[] dfs_visited = new int[n+1]; //중복 방문 방지 확인 배열
		int[] bfs_visited = new int[n+1];
		dfs(start, dfs_visited);
		sb.append("\n");
		bfs(start, bfs_visited);
		System.out.println(sb);
		
	}
	
	public static void dfs(int pos, int[] dfs_visited) {
		if(dfs_visited[pos] == 1) return;
		dfs_visited[pos] = 1;
		sb.append(pos).append(" ");
		for(int i=1; i<=n;i++) {
			if(graph[pos][i] == 1 && dfs_visited[i] == 0) {
				dfs(i, dfs_visited);
			}
		}
	}
	
	public static void bfs(int pos, int[] bfs_visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(pos);
		while(!queue.isEmpty()) {
			int v = queue.poll();
			bfs_visited[v] = 1;
			//System.out.println(v);
			sb.append(v).append(" ");
			for(int i =1; i<= n; i++) {
				if(graph[v][i] == 1 && bfs_visited[i] == 0 ) {
					//System.out.println(i);
					bfs_visited[i] = 1;
					queue.add(i);
				}
			}
			
		}
		
	}

}
