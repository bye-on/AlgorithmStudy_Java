import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        long M = Long.parseLong(str[1]);
        String[] input = br.readLine().split(" ");

        long[] arr = new long[N];

        long max = 0;
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(input[i]);
            arr[i] = num;
            max = Math.max(max, num);
        }

        long s = 0;
        long e = max;
        long maxHeight = 0;
        while (s <= e) { // while (s < e) X
            long m = (s + e) / 2; // **long type**

            long cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (m < arr[i])
                    cnt += (arr[i] - m);
            }

            if (cnt >= M) {
                maxHeight = Math.max(maxHeight, m);
                s = m + 1;
            } else
                e = m - 1;
        }
        System.out.println(maxHeight);
    }
}
