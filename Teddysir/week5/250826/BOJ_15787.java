import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_15787 {

	static int[] train;
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		train = new int[N + 1]; // N개의 열차, 시트는 0~21 만약 0이나 21이면 없애버리도록?

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			if (order == 1) {
				int tempTrain = Integer.parseInt(st.nextToken());
				int tempSeat = Integer.parseInt(st.nextToken());
				train[tempTrain] |= (1 << tempSeat);
			} else if (order == 2) {
				int tempTrain = Integer.parseInt(st.nextToken());
				int tempSeat = Integer.parseInt(st.nextToken());
				train[tempTrain] &= ~(1 << tempSeat);
			} else if (order == 3) {
				int tempTrain = Integer.parseInt(st.nextToken());
				train[tempTrain] <<= 1; // 한칸씩 왼쪽으로 밀고
				train[tempTrain] &= ((1 << 21) - 2); // 밀고 21, 0번쨰 안씀
			} else {
				int tempTrain = Integer.parseInt(st.nextToken());
				train[tempTrain] >>= 1;
				train[tempTrain] &= ((1 << 21) - 2);

			}

		}

		Set<Integer> check = new HashSet<Integer>();
		for (int i = 1; i <= N; i++) {
			check.add(train[i]);
		}

		System.out.println(check.size());

	}

}
