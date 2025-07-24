package teddysir.week1.day_250724;

import java.io.*;
import java.util.*;

public class BOJ_13305 {

	static int N;
	static int[] oil_money;
	static int[] length;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		oil_money = new int[N];
		length = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N; i++) {
			length[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			oil_money[i] = Integer.parseInt(st.nextToken());
		}
		long totalMoney = 0;

		long temp = oil_money[0];

		for (int j = 0; j < N - 1; j++) {
			if (temp > oil_money[j]) {
				temp = oil_money[j];
			}

			totalMoney += (temp * length[j + 1]);
		}

		System.out.println(totalMoney);

	}

}
