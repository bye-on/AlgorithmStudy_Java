
import java.io.*;
import java.util.*;

public class BOJ_2531 {

	static int dish, kind, seq, coupon, ans;
	static int[] sushi;
	static int[] counter; // 초밥 종류를 체크하는 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		dish = Integer.parseInt(st.nextToken());
		kind = Integer.parseInt(st.nextToken());
		seq = Integer.parseInt(st.nextToken());
		coupon = Integer.parseInt(st.nextToken());

		sushi = new int[dish + seq - 1];
		counter = new int[kind + 1];

		for (int i = 0; i < dish; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		for (int i = dish; i < dish + seq - 1; i++) {
			sushi[i] = sushi[i - dish];
		}

		solution();
		System.out.println(ans);
	}

	static void solution() {

		int s = 0;
		int e = s + seq - 1; // 0 + 4-1
		Set<Integer> set = new HashSet<>();
		for (int i = s; i <= e; i++) {
			counter[sushi[i]]++; // 이렇게 일단 해당 스시 저장해두고
			set.add(sushi[i]);
		}
		set.add(coupon);
		counter[coupon]++;
		ans = set.size();
		int result = set.size();
		ans = result;

		while (s != dish) {

			int tempS = counter[sushi[s]];
			if (tempS > 0) {
				counter[sushi[s]]--;
				if (counter[sushi[s]] == 0) {
					result--;
				}
			}

			s++;
			e = s + seq - 1;

			int tempE = counter[sushi[e]];
			if (tempE == 0) {
				counter[sushi[e]]++;
				result++;
			} else {
				counter[sushi[e]]++;
			}

			ans = Math.max(result, ans);
		}
	}

}
