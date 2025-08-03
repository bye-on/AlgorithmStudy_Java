import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446 {
	static class Node implements Comparable<Node> {
		int target;
		int weight;

		Node(int target, int weight) {
			this.target = target;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}

	static int shortcut, length;
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	static int[] dist;
	static List<Node>[] graph; // 정적배열속 동적배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		shortcut = Integer.parseInt(st.nextToken());
		length = Integer.parseInt(st.nextToken());

		dist = new int[length + 1]; // 총 거리만큼 거리 배열 선언해주고
		Arrays.fill(dist, Integer.MAX_VALUE); // 모든 배열을 최대값으로 설정해준다.
		dist[0] = 0; // 시작 노드는 0

		graph = new List[length + 1];
		for (int i = 0; i <= length; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < length; i++) {
			graph[i].add(new Node(i + 1, 1)); // 다음 노드로 갈때마다 비용 1씩증가
		}

		for (int i = 0; i < shortcut; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			if (weight < (target - start) && target <= length) { // 가중치가 해당 구간보다 비용이 적게들고,
				// 목표가 길이보다 길면안되겠지? -> 150까지 길인데 151이면 넘치니까 안넣음!
				graph[start].add(new Node(target, weight)); // 해당 시작점부터 다음 노드까지 몇 비용만큼의 지름길인지를 저장해준다.
			}

		}
		dijkstra();
		System.out.println(dist[length]);

	}

	static void dijkstra() {
		pq.add(new Node(0, 0));

		while (!pq.isEmpty()) {
			Node temp = pq.poll();

			int tempTarget = temp.target;
			int tempWeigth = temp.weight;

			if (tempWeigth > dist[tempTarget]) {
				continue;
			}

			for (Node next : graph[tempTarget]) {
				int newWeight = dist[tempTarget] + next.weight;
				if (newWeight < dist[next.target]) {
					dist[next.target] = newWeight;
					pq.add(new Node(next.target, newWeight));
				}
			}
		}
	}
}
