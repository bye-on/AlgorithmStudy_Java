package week01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		dp[1] = 0;
		
		int now;
		for(int i=2; i<=N; i++) {
			now = dp[i-1] + 1;
			if(i%3==0) now = Math.min(now, dp[i/3]+1);
			if(i%2==0) now = Math.min(now, dp[i/2]+1);
			dp[i] = now;
		}
		System.out.println(dp[N]);
	}
}
