import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_14510 {
	static Queue<Integer> even_q, odd_q;
	static int TC, tree, ans, maxTree;
	static int[] trees;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		TC = Integer.parseInt(br.readLine());

		for (int k = 1; k <= TC; k++) {

			maxTree = 0;
			
			tree = Integer.parseInt(br.readLine());
			trees = new int[tree];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < tree; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
				maxTree = Math.max(trees[i], maxTree);
			}
			ans = 0;
			solution();
			

			sb.append("#").append(k).append(" ").append(ans).append("\n");

		}
		System.out.println(sb);

	}

	static void solution() {
		even_q = new LinkedList<>();
		odd_q = new LinkedList<>();

		for (int i = 0; i < tree; i++) {
			if (trees[i] == maxTree) {
				continue;
			}
			int temp = maxTree - trees[i];

			for (int j = 0; j < temp / 2; j++) {
				even_q.add(2); // ���� ���� ���� / 2��ŭ ¦�� �߰�
			}
			if (temp % 2 == 1) { // ������ ������ 1 �߰�
				odd_q.add(1);
			}
		}

		if (even_q.size() >= odd_q.size()) { // ¦�� ���� Ȧ�� ������ �ʹ� ������
			while (true) {
				if (even_q.size() <= odd_q.size()) {
					ans = even_q.size() + odd_q.size(); // ����
					break;
				}
				even_q.poll();
				odd_q.add(1);
				odd_q.add(1); // 2 ���� 1 �� �� �ֱ�
			}
		} else {
			ans += even_q.size() * 2; // ¦�� ������ŭ ���ϰ� -> �ٵ� �̰ź��� Ŭ ��찡 �ֳ�
			int gap = odd_q.size() - even_q.size();
			ans = ans + gap + (gap - 1); // 1 0 1 0 1  0 1 0 1
		}

	}

}
