import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[301];
        int[] arr = new int[301];
        for (int i = 1; i <= n; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
        }

        dp[0] = 0;
        dp[1] = arr[1];
        dp[2] = dp[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]) + arr[i];
        }

        System.out.println(dp[n]);
    }
}
