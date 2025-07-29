import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        dp[1] = 0; // 여기서 맞틀 갈림

        for (int i = 2; i <= n; i++) {
           
            dp[i] = dp[i - 1] + 1;

            if ((i % 3) == 0)
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            if ((i % 2) == 0)
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
        }

        System.out.println(dp[n]);
	}
}

