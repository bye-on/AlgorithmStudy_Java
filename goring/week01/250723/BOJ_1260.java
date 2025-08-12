package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1260 {
	static StringBuilder sb;
	static int[][] node;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[N+1];
		 node = new int[M][2];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			node[i][0] = Integer.parseInt(st.nextToken());
			node[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//dfs
		sb = new StringBuilder();
		dfs(S, visited);
		
		
		//bfs
		Deque<Integer> move = new ArrayDeque<Integer>();
		visited = new boolean[N+1];
		int now = S;
		sb.append("\n");
		move.addLast(now);
		
		PriorityQueue<Integer> list;
		while(!move.isEmpty()) {
			now = move.pollFirst();
			if(!visited[now]) {
				visited[now] = true;
				sb.append(now).append(" ");
				list = new PriorityQueue<>();
				for(int[] n : node) {
					if(n[0] == now) list.add(n[1]);
					if(n[1] == now) list.add(n[0]);
				}
				while(!list.isEmpty()) {
					move.addLast(list.poll());
				}
			}
		}
		System.out.println(sb.toString());
	}
	
	static void dfs(int now, boolean[] visited) {
		if(visited[now]) return;
		
		PriorityQueue<Integer> list = new PriorityQueue<>();
		visited[now] = true;
		sb.append(now).append(" ");
		for(int[] n : node) {
			if(n[0] == now) list.add(n[1]);
			if(n[1] == now) list.add(n[0]);
		}
		
		while(!list.isEmpty()) {
			dfs(list.poll(), visited);
		}
	}
}
