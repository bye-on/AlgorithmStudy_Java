package for_A_Problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_17471 {

	static int N, ans;
	static int[] arr;
	static int[][] map;
	static boolean[] visited;
	static boolean[] sep_visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];
		map = new int[N + 1][N + 1];

		// 지역별로 인구수 추가
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 각 구역별로 연결
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int link = Integer.parseInt(st.nextToken());
				map[i][link] = map[link][i] = 1; // 연결됨
			}
		}

		// 분리된거인지 체크
		int sep_count = 0;
		ans = Integer.MAX_VALUE;
		sep_visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!sep_visited[i]) {
				sep_checker(i);
				sep_count++;
			}
		}
		if (sep_count >= 3) { // 구역 3개 이상이면 안됨
			System.out.println(-1);
			return;
		} else if (sep_count == 2) { // 구역이 두개일땐
			sep_visited = new boolean[N + 1];
			sep_checker(1); // 한 구역만 true로 체크하고
			checker(sep_visited); // 체크된 구역끼리만 더해서
			System.out.println(ans); // 답으로 출력하고 끝.
			return;
		} else { // 아닐때는 아래 로직 태우기
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];
				solution(i);
			}
		}

		System.out.println(ans);
	}

	// 아래 로직에서는 인접한 리스트들조합으로 다 구하기
	static void solution(int idx) {
		if (idx > N) {
			checker(visited);
			return;
		}

		// 현재 idx 구역을 선택하는 경우
		visited[idx] = true;
		solution(idx + 1);

		// 현재 idx 구역을 선택하지 않는 경우
		visited[idx] = false;
		solution(idx + 1);
	}

	// 구역을 구한게 찾아지면 그 구역대로 합 차이 구하기
	static void checker(boolean[] check) {
		if (!isConnected(check, true) || !isConnected(check, false))
			return;

		int a = 0;
		int b = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i]) {
				a += arr[i];
			} else {
				b += arr[i];
			}
		}

		int temp_ans = Math.abs(a - b);
		ans = Math.min(temp_ans, ans);
	}

	static boolean isConnected(boolean[] check, boolean flag) {
		boolean[] visit = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();

		// 시작점 찾기
		for (int i = 1; i <= N; i++) {
			if (check[i] == flag) {
				q.add(i);
				visit[i] = true;
				break;
			}
		}
		if (q.isEmpty())
			return false; // 해당 그룹에 구역 없음

		int count = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			count++;
			for (int i = 1; i <= N; i++) {
				if (!visit[i] && map[cur][i] == 1 && check[i] == flag) {
					visit[i] = true;
					q.add(i);
				}
			}
		}

		// 해당 그룹의 원래 구역 수와 BFS로 탐색된 수가 같아야 연결됨
		int groupSize = 0;
		for (int i = 1; i <= N; i++) {
			if (check[i] == flag)
				groupSize++;
		}
		return count == groupSize;
	}

	// 분리된 구역 체크하기
	static void sep_checker(int start) {

		sep_visited[start] = true;
		for (int i = 1; i <= N; i++) {
			if (!sep_visited[i] && (map[start][i] == 1 || map[i][start] == 1)) {
				sep_visited[i] = true;
				sep_checker(i);
			}
		}

	}

}
