package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1158 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Deque<Integer> map = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			map.addLast(i);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int now;
		while(!map.isEmpty()) {
			for(int i=1; i<K; i++) {
				now = map.pollFirst();
				map.addLast(now);
			}
			now = map.pollFirst();
			if(!map.isEmpty()) {
				sb.append(now).append(", ");
			} else sb.append(now);
		}
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
