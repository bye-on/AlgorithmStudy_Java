package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_14567 {
	static int N;
	static int M;
	static ArrayList<Deque<Integer>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			list.add(new ArrayDeque());
		}
		int[] result = new int[N+1];
		boolean[] visited = new boolean[N+1];
		int x,y;
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			list.get(y).add(x);
		}
		
		for(int i=1; i<=N; i++) {
			findBefore(i, visited, result);
		}
		
		StringBuilder sb= new StringBuilder();
		for(int i=1; i<=N; i++) {
			sb.append(result[i]).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	public static void findBefore(int i, boolean[] visited, int[] result) {
		if(visited[i]) return;
		
		Deque<Integer> a = list.get(i);
		if(a.size()==0) {
			result[i] = 1;
			visited[i] = true;
			return;
		}
		
		int now;
		while(!a.isEmpty()) {
			now = a.poll();
			
			if(result[now] == 0) {
				findBefore(now, visited, result);
			}
			
			result[i] = Math.max(result[now] + 1, result[i]);
		}
		
		visited[i] = true;
	}
}
