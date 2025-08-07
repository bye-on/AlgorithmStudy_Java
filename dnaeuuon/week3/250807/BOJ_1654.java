import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        long max = 0;
        int[] arr = new int[N + 1];
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);
            arr[i] = num;
        }

        long s = 1;
        long e = max;
        long result = 0;
        while (s <= e) {
            long m = (s + e) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i] / m;
            }

            if (cnt >= N) {
                result = Math.max(result, m);
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        System.out.println(result);
    }
}