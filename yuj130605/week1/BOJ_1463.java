package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1463 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Integer[] cnt = new Integer[N+1];
		cnt[0] = cnt[1] = 0;

		System.out.println(dp(N, cnt));
	}

	static int dp(int N, Integer[] cnt){
		if (cnt[N] != null) {
			return cnt[N];
		}

		while (cnt[N] == null) {
			if (N%6 == 0) {
				cnt[N] = Math.min(dp(N-1, cnt), Math.min(dp(N/3, cnt), dp(N/2, cnt)))+1;
			} else if(N%3 == 0){
				cnt[N] = Math.min(dp(N-1, cnt), dp(N/3, cnt))+1;
			} else if(N%2 == 0){
				cnt[N] = Math.min(dp(N-1, cnt), dp(N/2, cnt))+1;
			} else {
				cnt[N] = dp(N-1, cnt)+1;
			}
		}

		return cnt[N];
	}
}