package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
	static int N, M;
	static boolean[] used;
	static int[] arr;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		used = new boolean[N + 1];
		arr = new int[M];

		backTrack(0);

	}

	static void backTrack(int dep) {
		StringBuilder tempSb = new StringBuilder();

		if (dep == M) {
			for (int i = 0; i < M; i++) {
				tempSb.append(arr[i]).append(" ");
			}
			System.out.println(tempSb);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!used[i]) {
				used[i] = true;
				arr[dep] = i;
				backTrack(dep + 1);
				used[i] = false;
			}
		}
	}

}
