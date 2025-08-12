package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14235 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int input = Integer.parseInt(st.nextToken());
			if (input == 0) {
				if (pq.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			} else {
				for (int j = 0; j < input; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}
}
