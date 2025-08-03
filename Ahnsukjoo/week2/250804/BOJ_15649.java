import java.io.*;

public class Main {

	static int N, M;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		visited = new boolean[N + 1]; // 1부터 N까지 사용 표시
		arr = new int[M];           // 출력될 순열 배열

		dfs(0);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}
