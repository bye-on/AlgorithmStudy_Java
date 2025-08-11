import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import javax.imageio.IIOException;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		int[] arr = new int[N];
		int sum = 0;
		int count = 0;
		StringTokenizer stringTokenizer1 = new StringTokenizer(bufferedReader.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stringTokenizer1.nextToken());
		}
		for (int i = 0; i < N; i++) {
			sum = 0;

			for (int j = i; j < N; j++) {
				if (M < sum) {
					break;
				}
				if (M > sum) {
					sum += arr[j];
					if (sum == M) {
						count++;
						break;
					}
				}
			}
		}
		System.out.println(count);
	}
}
