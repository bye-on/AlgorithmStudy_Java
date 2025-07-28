package teddysir.week1.day_250724;

import java.io.*;
import java.util.*;

public class BOJ_11047 {
	static int N, K, coin;
	static int[] arr;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];

		for (int i = N - 1; i >= 0; i--) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		coin = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] <= K) {
				coin += (K / arr[i]);
				int temp = (K / arr[i]);
				K -= (temp * arr[i]);
			}
		}
		System.out.println(coin);

	}

}
