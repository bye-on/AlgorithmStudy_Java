package teddysir.week1.day_250723;

import java.util.*;
import java.io.*;

class BOJ_16173 {

	static int N;
	static String ans;
	static int[][] map;
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = "Hing";

		solution(0, 0);
		System.out.println(ans);

	}

	static void solution(int x, int y) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int goCount = map[temp[0]][temp[1]];
			if (goCount == 0) {
				return;
			}
			for (int i = 0; i < 2; i++) {
				int nx = temp[0] + (dx[i] * goCount);
				int ny = temp[1] + (dy[i] * goCount);

				if (nx >= 0 && ny >= 0 && nx < N && ny < N) {

					if (map[nx][ny] == -1) {
						ans = "HaruHaru";
						return;
					}
					q.add(new int[] { nx, ny });

				}

			}
		}
	}

}