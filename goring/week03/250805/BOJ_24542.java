package week03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24542 {
	static int[] list;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// list 나는 나로 초기화
		list = new int[N+1];
		for(int i=1; i<=N; i++) list[i] = i;
		
		// 노드 별로 union-find 수행
		int x, y;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			union(x, y);
		}
		
		long answer = 1L;
		int[] count = new int[N+1];
		
		// 그룹 하나 당 몇 명이 포함되어 있는 지 체크
		for(int i=1; i<=N; i++) {
			int root = find(i);
			count[root]++;
		}
		
		// 그룹당 명수 * ...
		for(int i=1; i<=N; i++) {
			if(count[i]==0) continue;
			answer = (answer * count[i])%1000000007;
		}

		System.out.println(answer);
	}
	
	// 합집합 만들기
	public static void union (int x, int y) {
		// 부모 노드 찾아서 가져오기
		x = find(x);
		y = find(y);
		
		if(x<y) list[y] = x;
		else list[x] = y;
	}
	
	// 부모 노드 찾기
	public static int find(int x) {
		if(list[x]==x) {
			return x;
		}
		
		return list[x] = find(list[x]);
	}
	
	// 같은 부모 노드를 가지고 있는 지 확인
//	public static boolean isSame(int x, int y) {
//		x = find(x);
//		y = find(y);
//		
//		if(x==y) return true;
//		else return false;
//	}
}
