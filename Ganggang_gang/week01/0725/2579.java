//2579번

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] score = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(br.readLine().trim());
        }

        //n이 1 혹은 2 때
        if (N == 1) {
            System.out.println(score[1]);
            return;
        }
        if (N == 2) {
            //두번째 계단으로 바로 시작하기
            System.out.println(score[1] + score[2]);
            return;
        }

        int[][] dp = new int[N + 1][2];

        //초기값
        dp[1][0] = score[1];
        dp[1][1] = score[1];

        dp[2][0] = score[2]; //두칸해서 밟을때
        dp[2][1] = score[1] + score[2]; //두칸 해서 연속 밟을때

        //3번부터 n번까지 채우기
        for (int i = 3; i <= N; i++) {
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + score[i];
            dp[i][1] = dp[i - 1][0] + score[i];
        }

        int answer = Math.max(dp[N][0], dp[N][1]);
        System.out.println(answer);
    }
}
