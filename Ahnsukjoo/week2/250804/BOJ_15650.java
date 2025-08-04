import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[] arr;
	static int count = 1;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		visit = new boolean[N + 1];
		arr = new int[M];
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

		for (int i = count; i <= N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = i;
				count = i;
				dfs(depth + 1);
				visit[i] = false;
			}
		}
	}

}
