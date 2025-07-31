package forStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_18352 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		// node 초기화
		ArrayList<ArrayList<Integer>> node = new ArrayList<>();
		for(int i=0; i<=N; i++) node.add(new ArrayList<>());
		
		int from, to;
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			
			node.get(from).add(to);
		}
		
		int[] price = new int[N+1];
		Arrays.fill(price, -1);
		Deque<Integer> list = new ArrayDeque<>();
		list.add(X);
		price[X] = 0;
		
		int now;
		while(!list.isEmpty()) {
			now = list.pollFirst();
			for(int i : node.get(now)) {
				if(price[i]==-1) {
					price[i] = price[now] + 1;
					list.add(i);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		boolean f = false;
		for(int i=1; i<=N; i++) {
			if(price[i]==K) {
				sb.append(i).append("\n");
				f = true;
			}
		}
		
		if(f) System.out.println(sb.toString());
		else System.out.println(-1);
	}
}
