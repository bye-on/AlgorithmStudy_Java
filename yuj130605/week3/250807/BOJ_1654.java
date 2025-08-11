import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    static int K, N;
    static long result;
    static int[] len;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken()); // 랜선 개수
        N = Integer.parseInt(st.nextToken());

        // 입력
        len = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            len[i] = Integer.parseInt(br.readLine());

            if (len[i] > max)
                max = len[i];
        }

        result = 0;
        search(1, max);

        System.out.println(result);

    }

    static void search(long start, long end) {
        long sum = 0;
        long mid = (start + end) / 2;

        for (int i : len) {
            sum += i / mid;
        }

        if (sum < N) {
            if (start <= mid - 1) {
                search(start, mid - 1);
            }
        } else if (sum >= N) {
            if (result <= mid)
                result = mid;

            if (mid + 1 <= end) {
                search(mid + 1, end);
            }
        }
    }
}