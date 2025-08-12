package week02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2056 {
	static ArrayList<Deque<Integer>> list = new ArrayList<>();
	static int[] result;
	static int[] workH;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		workH = new int[N+1];
		
		StringTokenizer st;
		int JCount;
		for(int i=0; i<=N; i++) list.add(new ArrayDeque<>());
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			workH[i] = Integer.parseInt(st.nextToken());
			JCount = Integer.parseInt(st.nextToken());
			for(int j=0; j<JCount; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));				
			}
		}
		
		result = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			findBefore(i);			
		}
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer, result[i]);
		}
		System.out.println(answer);
	}
	
	public static void findBefore(int i) {
		if(visited[i]) return;
		
		Deque<Integer> a = list.get(i);
		
		if(a.size()==0) {
			result[i] = workH[i];
			visited[i] = true;
		}
		
		int now;
		while(!a.isEmpty()) {
			now = a.poll();
			if(result[now]==0) {
				findBefore(now);
			}
			result[i] = Math.max(result[i], result[now]+workH[i]);
		}
		visited[i] = true;
	}
}
