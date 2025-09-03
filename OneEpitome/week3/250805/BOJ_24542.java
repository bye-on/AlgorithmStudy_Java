import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int N = Integer.parseInt(split[0]), M = Integer.parseInt(split[1]);
		
		List<List<Integer>> graph = new ArrayList<>();
		for (int i=0; i<N+1; i++) {
			graph.add(new ArrayList<Integer>());
		}
		boolean[] visited = new boolean[N+1];
		
		for (int i=0; i<M; i++) {
			split = br.readLine().split(" ");
			int u = Integer.parseInt(split[0]), v = Integer.parseInt(split[1]);
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		long result = 1;
		for (int i=1; i<N+1; i++) {
			if (!visited[i]) result = (result * dfs(graph, visited, i)) % 1000000007;
		}
		
		System.out.println(result);
	}
	
	public static long dfs(List<List<Integer>> graph, boolean[] visited, int v) {
		Stack<Integer> stack = new Stack<>();
		stack.push(v);
		visited[v] = true;
		
		long count = 0;
		while (!stack.isEmpty()) {
			int now = stack.pop();
			count++;
			
			for (Integer adj : graph.get(now)) {
				if (!visited[adj]) {
					stack.push(adj);
					visited[adj] = true;
				}
			}
		}
		
		return count;
	}
}

