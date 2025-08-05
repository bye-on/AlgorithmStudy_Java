package practice;

import java.io.*;
import java.util.*;

public class BOJ_11660 {

	static int N, M;
	static int[][] map;
	static int[][] presum;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		presum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		presum[1][1] = map[1][1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				presum[i][j] = map[i][j] + presum[i - 1][j] + presum[i][j - 1] - presum[i - 1][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = presum[x2][y2];

			if (x1 > 1)
				result -= presum[x1 - 1][y2];
			if (y1 > 1)
				result -= presum[x2][y1 - 1];
			if (x1 > 1 && y1 > 1) {
				result += presum[x1 - 1][y1 - 1];
			}
			sb.append(result).append("\n");

		}

		System.out.println(sb);

	}

}
