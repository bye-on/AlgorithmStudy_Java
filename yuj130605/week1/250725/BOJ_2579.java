import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] score = new int[N];
        for (int i = 0; i < N; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N][2];

        int max = 0;
        if (N < 2) {
            max = score[0];
        } else {
            findMax(N, score, dp);
            max = Math.max(dp[N - 1][0], dp[N - 1][1]);
        }

        System.out.println(max);

    }

    static void findMax(int N, int[] score, int[][] dp) {

        dp[0][0] = score[0];
        dp[0][1] = 0;
        dp[1][0] = score[0] + score[1];
        dp[1][1] = score[1];

        for (int i = 2; i < N; i++) {
            dp[i][0] = dp[i - 1][1] + score[i];
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];
        }

    }

}