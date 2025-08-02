import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] height = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            height[i] = tmp;

            if (tmp > max)
                max = tmp;

        }

        Arrays.sort(height);

        System.out.println(cut(N, M, height, 0, max));

    }

    static int cut(int N, int M, int[] height, int min, int max) {

        int mid = (min + max) / 2;

        if (min < max) {
            long sum = sum(N, M, height, mid);
            if (sum == M) {
                return mid;
            } else if (sum > M) {
                return cut(N, M, height, mid + 1, max);
            } else if (sum < M) {
                return cut(N, M, height, min, mid);
            }
        }

        return mid - 1;
    }

    static long sum(int N, int M, int[] height, int mid) {
        long sum = 0;
        for (int j = 0; j < N; j++) {
            if (height[j] > mid) {
                sum += height[j] - mid;
            }
        }

        return sum;
    }
}
