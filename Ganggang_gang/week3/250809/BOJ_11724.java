import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.List;


public class BOJ_11724{
	static int n,m;
	static int ans = 0;
	static List<Integer>[] arr;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		for(int i =0; i<n+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i =0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			arr[a].add(b);
			arr[b].add(a);
			
		}
		visited = new boolean[n+1];
		for(int i = 1; i<= n ;i++) {
			if(!visited[i]) {
				dfs(i);
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}
	
	public static void dfs(int node) {
		visited[node] = true;
		
		for(int x: arr[node]) {
			if (!visited[x]) {
				dfs(x);
			}
		}
	}

}
