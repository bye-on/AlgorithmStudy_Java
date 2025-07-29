import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		
		int[][] graph = new int[N+1][N+1];
		
		for (int i=0; i<M; i++) {
			int a, b;
			String[] temp = br.readLine().split(" ");
			a = Integer.parseInt(temp[0]);
			b = Integer.parseInt(temp[1]);
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		boolean visited[] = new boolean[N+1];
		dfs(graph, visited, V);
		System.out.println();
		visited = new boolean[N+1];
		bfs(graph, visited, V);
	}
	
	private static void dfs(int[][] graph, boolean[] visited, int v) {
		visited[v] = true;
		System.out.printf("%d ", v);
		
		for (int i=0; i<graph[v].length; i++) {
			if ((graph[v][i] == 1) && (visited[i] == false)) {
				dfs(graph, visited, i);
			}
		}
	}
	
	private static void bfs(int[][] graph, boolean[] visited, int v) {
		visited[v] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		
		while (!q.isEmpty()) {
			int now = q.poll();
			System.out.printf("%d ", now);
			
			for (int i=0; i<graph[now].length; i++) {
				if ((graph[now][i] == 1) && (visited[i] == false)) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}
}

