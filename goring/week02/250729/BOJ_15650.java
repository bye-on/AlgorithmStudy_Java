package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		visited = new boolean[N+1];
		
		StringBuilder sb = new StringBuilder();
		dfs(sb, 0, 1);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(StringBuilder sb, int level, int j) {
		if(level == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=j; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[level]=i;
				dfs(sb, level+1, i);
				visited[i] = false;
			}
		}
	}
}

