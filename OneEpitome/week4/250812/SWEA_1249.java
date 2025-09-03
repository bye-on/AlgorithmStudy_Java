import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
	public static int result = Integer.MAX_VALUE;
	public static int[][] d = {{-1,0}, {1,0}, {0,-1}, {0,1}};
	public static int t;

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("Test4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] graph = new int[N][N];
			
			for (int i=0; i<N; i++) {
				String[] split = br.readLine().split("");
				for (int j=0; j<N; j++) {
					graph[i][j] = Integer.parseInt(split[j]);
				}
			}
			
			dijkstra(graph);
			
			System.out.printf("#%d %d\n", t+1, dijkstra(graph));
		}
	}
	
	public static int dijkstra(int[][] graph) {
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.get(0) > o2.get(0)) {
					return 1;
				} else if (o1.get(0) < o2.get(0)) {
					return -1;
				}
				
				return 0;
			}
		});
		
		pq.add(Arrays.asList(0, 0, 0));
		
		int[][] distance = new int[graph.length][graph.length];
		for (int i=0; i<graph.length; i++) {
			for (int j=0; j<graph.length; j++) {
				distance[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int[][] d = {{-1,0},{1,0},{0,-1},{0,1}};
		
		while (!pq.isEmpty()) {
			List<Integer> poll = pq.poll();
			int cost = poll.get(0), now_r = poll.get(1), now_c = poll.get(2);
			
			if (cost > distance[now_r][now_c]) {
				continue;
			}
			
			for (int[] dm : d) {
				int dr = dm[0], dc = dm[1];
				int new_r=now_r+dr, new_c=now_c+dc;
				
				if ((new_r>=0) && (new_r<graph.length) && (new_c>=0) && (new_c<graph.length)) {
					if ((cost + graph[new_r][new_c]) < distance[new_r][new_c]) {
						distance[new_r][new_c] = cost + graph[new_r][new_c];
						pq.add(Arrays.asList(cost + graph[new_r][new_c], new_r, new_c));
					}
				}
			}
		}
		
		return distance[graph.length-1][graph.length-1];
	}
}

