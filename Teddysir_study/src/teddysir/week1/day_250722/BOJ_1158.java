package teddysir.week1.day_250722;

import java.io.*;
import java.util.*;

public class BOJ_1158 {

	static int N, K;
	static Deque<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		sb.append("<");
		for (int i = 0; i < N - 1; i++) {
			sb.append(solution()).append(", ");
		}
		sb.append(q.poll()).append(">");

		System.out.println(sb);

	}

	static int solution() {
		for (int i = 0; i < K-1; i++) {
			q.add(q.pollFirst());
		}

		return q.pollFirst();
	}

}
