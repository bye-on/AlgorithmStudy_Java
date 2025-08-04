import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	String S = "4 4 2 1\n"
		+ "1 2\n"
		+ "1 3\n"
		+ "2 3\n"
		+ "2 4";
	static int[] visit;


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		int K = Integer.parseInt(stringTokenizer.nextToken());
		int X = Integer.parseInt(stringTokenizer.nextToken());
		visit = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer>[] arrayLists = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arrayLists[i] = new ArrayList<Integer>();
			visit[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
			int a = Integer.parseInt(stringTokenizer1.nextToken());
			int b = Integer.parseInt(stringTokenizer1.nextToken());
			arrayLists[a].add(b);
		}

		queue.add(X);
		visit[X] = 0;
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : arrayLists[current]) {
				// 방문하지 않은 도시만
				if (visit[next] == -1) {
					visit[next] = visit[current] + 1;
					queue.add(next);
				}
			}
		}
		boolean found = false;
		for (int i = 1; i < visit.length; i++) {
			if (visit[i] == K) {
				System.out.println(i);
				found = true;
			}
		}
		if (!found) {
			System.out.println(-1);
		}

	}
}
