package week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17471 {
	static ArrayList<ArrayList<Integer>> node;
	static int[] population;
	static int N, answer;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 구역의 수
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 구역 당 인구 수
		population = new int[N+1];
		// 모든 구역의 인구를 합친 수
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		// 연결 노드 자료형
		node = new ArrayList<>();
		for(int i=0; i<=N; i++) {
			node.add(new ArrayList<>());
		}
		
		// 연결 노드와 노드의 수 초기화
		int L;
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			for(int j=0; j<L; j++) {
				node.get(i).add(Integer.parseInt(st.nextToken()));				
			}
		}
		
		answer = Integer.MAX_VALUE;
		boolean[] visited = new boolean[N+1];
		// 선거구 나누기
		findplace(1, visited);
		answer = answer==Integer.MAX_VALUE ? -1 : answer;
		System.out.println(answer);
		
	}
	
	public static void findplace(int level, boolean[] visited) {
		// 부분 수열 완성
		 if(level==N+1) {
			 ArrayList<Integer> a = new ArrayList<>();
			 ArrayList<Integer> b = new ArrayList<>();
			 
			 for(int i=1; i<=N; i++) {
				 if(visited[i]) {
					 a.add(i);
				 } else b.add(i);
			 }
			 
			 if(a.size()==0 || b.size()==0) return;
			 
			 int result1=0, result2=0;
			 // a와 b 구역 둘 다 요소가 모두 연결되어 있는 지 확인
			 if(union(a) && union(b)) {
				 for(int c : a) {
					 result1 += population[c];
				 }
				 for(int c : b) {
					 result2 += population[c];
				 }
				 
				 answer = Math.min((result1 > result2 ? result1 - result2 : result2 - result1), answer);
			 }
			 return;
		 }
		 
		 // 모든 부분 수열 모두 탐색
		 // 해당 요소를 선택 (a기준)
		 visited[level] = true;
		 findplace(level+1, visited);
		 // 해당 요소를 선택 X
		 visited[level] = false;
		 findplace(level+1, visited);
	}
	
	public static boolean union(ArrayList<Integer> list) {
		boolean[] visited = new boolean[N+1];
		Deque<Integer> a = new ArrayDeque<>();
		a.add(list.get(0)); 
		
		int now;
		while(!a.isEmpty()) {
			now = a.pollFirst();
			visited[now] = true;
			
			for(int n : node.get(now)) {
				if(!visited[n] && list.contains(n)) {
					visited[n] = true;
					a.addLast(n);
				}
			}
		}
		
		for(int i : list) {
			if(!visited[i]) return false;
		}
		return true;
	}
}
