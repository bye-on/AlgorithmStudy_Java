import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14510 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine()); // 나무 개수

            // 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] height = new int[N];
            int max = 0;
            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());

                if (height[i] > max) {
                    max = height[i];
                }
            }

            int odd = 0, even = 0;
            for (int i = 0; i < N; i++) {
                height[i] = max - height[i];

                if (height[i] != 0 && height[i] % 2 != 0) {
                    even += height[i] / 2;
                    odd++;
                } else if (height[i] != 0 && height[i] % 2 == 0) {
                    even += height[i] / 2;
                }
            }

            if (even > odd) {
                while (even - odd > 1) {
                    odd += 2;
                    even -= 1;
                }
            }

            int res = 0;
            if (odd > even) {
                res = 2 * odd - 1;
            } else if (odd < even) {
                res = 2 * even;
            } else {
                res = odd + even;
            }

            System.out.printf("#%d %d\n", test_case, res);
        }
    }
}
