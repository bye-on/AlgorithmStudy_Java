package teddysir.week1.day_250723;

import java.util.*;
import java.io.*;

class BOJ_1260 {

	static int node, line, start;
	static boolean[] visited;
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	static StringBuilder sb2 = new StringBuilder();

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		node = Integer.parseInt(st.nextToken());
		line = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		arr = new int[node + 1][node + 1];

		for (int i = 0; i < line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[a][b] = arr[b][a] = 1;
		}
		
		visited = new boolean[node + 1];
		sb2.append(start).append(" ");
		dfs(start);
		System.out.println(sb2);

		visited = new boolean[node + 1];
		bfs(start);
		System.out.println(sb);


	}

	static void dfs(int start) {

		visited[start] = true;

		for (int i = 1; i <= node; i++) {
			if (arr[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				sb2.append(i).append(" ");
				dfs(i);
				
			}
		}
	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;

		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 1; i <= node; i++) {
				if (arr[temp][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
			sb.append(temp).append(" ");
		}
	}

}
