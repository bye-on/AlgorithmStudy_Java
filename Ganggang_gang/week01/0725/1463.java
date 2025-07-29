import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            //1빼기
            int min = dp[i - 1] + 1;

            //2로 나누어 떨어질때
            if (i % 2 == 0) {
                min = Math.min(min, dp[i / 2] + 1);
            }

            //3으로 나누어 떨어질때
            if (i % 3 == 0) {
                min = Math.min(min, dp[i / 3] + 1);
            }

            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
