import java.io.*;
import java.util.*;

public class SWEA_1249 {

	static int TC, size, ans;
	static int[][] map;
	static int[][] dist;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	static class Node implements Comparable<Node> {
		int x, y, weight;

		Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			size = Integer.parseInt(br.readLine());
			map = new int[size][size];
			dist = new int[size][size];
//			Arrays.fill(dist[size], Integer.MAX_VALUE);

			for (int i = 0; i < size; i++) {
				String input = br.readLine();
				for (int j = 0; j < size; j++) {
					map[i][j] = input.charAt(j) - 48;
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			ans = 0;
			dijkstra(new Node(0, 0, 0));

			sb.append("#").append(k).append(" ").append(dist[size - 1][size - 1]).append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra(Node node) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(node);

		map[0][0] = dist[0][0] = 0;

		while (!pq.isEmpty()) {

			Node temp = pq.poll();

			int curX = temp.x;
			int curY = temp.y;
			int curWeight = temp.weight;

			if (curWeight > dist[curX][curY]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx < size && ny < size) {

					int newWeight = dist[curX][curY] + map[nx][ny];
					if (dist[nx][ny] > newWeight) {
						dist[nx][ny] = newWeight;
						pq.add(new Node(nx, ny, newWeight));
					}
				}
			}
		}

	}

}
