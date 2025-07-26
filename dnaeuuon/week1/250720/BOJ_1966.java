import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_1966 {
	public static class Pair<K, V> {
		public K first;
		public V second;
		
		public Pair(K first, V second) {
			this.first = first;
			this.second = second;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// 1. 현재 Queue의 가장 앞에 있는 문서의 중요도를 확인
		// 2. 나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면 인쇄하지 않고 가장 뒤에 배치
		// 높은 숫자가 우선순위 높
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			Queue<Pair<Integer, Integer>> q = new LinkedList<>();			
			String[] str = br.readLine().toString().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);
			
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			String[] input = br.readLine().toString().split(" ");
			
			for(int j = 0; j < input.length; j++) {
				int num = Integer.parseInt(input[j]);
				pq.add(-num);
				q.add(new Pair<>(j, num));
			}
			
			int cnt = 1;

			while(!q.isEmpty()) {
				if(-pq.peek() > q.peek().second) {
					q.add(q.poll());
				}
				else {
					if(q.peek().first == m) {
						sb.append(cnt).append("\n");
						break;
					}
					else {
						q.poll();
						cnt++;
					}
					pq.poll();					
				}
			}
		}
		System.out.println(sb.toString());
	}
}
