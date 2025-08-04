import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15650 {

	static int N, M;
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new boolean[N + 1];

		backTracking(0, 1);
		System.out.println(sb);

	}

	static void backTracking(int depth, int start) {

		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			backTracking(depth + 1, i + 1);
		}
	}

}
